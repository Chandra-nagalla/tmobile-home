package com.example.tmobile

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.tmobile.model.TMobileBusinessObject
import com.example.tmobile.model.TMobileHomePages
import com.example.tmobile.repository.TMobileHomeRepository
import com.example.tmobile.service.ServiceResult
import com.example.tmobile.ui.TMobileHomePageViewModel
import com.google.gson.Gson
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.*

@ExperimentalCoroutinesApi
class TMobileHomePageViewModelTest {
    private lateinit var viewModel: TMobileHomePageViewModel
    private val tmobileHomeRepository = mockk<TMobileHomeRepository>()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        coEvery { tmobileHomeRepository.fetchTMobileHomePages() } returns (tMobileHomeMockResult() as ServiceResult<TMobileBusinessObject>)
        viewModel = TMobileHomePageViewModel()
        viewModel.init(tmobileHomeRepository)
        Dispatchers.setMain(TestCoroutineDispatcher())
    }

    @After
    fun cleanUp() {
        Dispatchers.resetMain()
    }

    @Test
    fun `should make service call `() =
        runBlockingTest {
            viewModel.apply {
                getTMobileHomePageData()
                coVerify { tmobileHomeRepository.fetchTMobileHomePages() }
            }
        }

    private fun tMobileHomeMockResult(): ServiceResult<TMobileHomePages> {
        val result = Gson().fromJson(homePageJson, TMobileHomePages::class.java)
        return ServiceResult.Success(result)
    }

}


