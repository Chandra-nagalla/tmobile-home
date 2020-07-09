package com.example.tmobile.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmobile.model.TMobileHomePages
import com.example.tmobile.repository.TMobileHomeRepository
import com.example.tmobile.repository.TMobileHomeRepositoryImpl
import com.example.tmobile.service.ServiceResult
import kotlinx.coroutines.launch

class TMobileHomePageViewModel : ViewModel() {
    private lateinit var tMobileHomePageRepository: TMobileHomeRepository
    var tMobileHomePageData = MutableLiveData<TMobileHomePages>()


    fun init() {
        this.tMobileHomePageRepository = TMobileHomeRepositoryImpl()
    }

    fun getTMobileHomePageData() {
        viewModelScope.launch {
            when(
                val result = tMobileHomePageRepository.fetchTMobileHomePages()
                ) {
                is ServiceResult.Error -> {

                }
                is ServiceResult.Success -> {
                    val response = result.data as TMobileHomePages
                    tMobileHomePageData.value = response
                }
            }
        }
    }
}