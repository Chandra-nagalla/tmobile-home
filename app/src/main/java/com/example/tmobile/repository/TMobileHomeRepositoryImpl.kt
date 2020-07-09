package com.example.tmobile.repository

import com.example.tmobile.model.TMobileBusinessObject
import com.example.tmobile.model.TMobileHomePages
import com.example.tmobile.service.RetrofitCallHandler
import com.example.tmobile.service.RetrofitService
import com.example.tmobile.service.ServiceResult
import com.example.tmobile.service.TMobileHomeService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TMobileHomeRepositoryImpl(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val tMobileService: TMobileHomeService = RetrofitService.createTMobileService()
) : TMobileHomeRepository {

    override suspend fun fetchTMobileHomePages(): ServiceResult<TMobileBusinessObject> {
        val result = withContext(ioDispatcher) {
            RetrofitCallHandler.processCall {
                tMobileService.getPages()
            }
        }

        return when(result) {
            is ServiceResult.Success -> transformResponseToTMobileHomePagesObject(result.data)
            is ServiceResult.Error -> result
        }
    }

    private fun transformResponseToTMobileHomePagesObject(response: TMobileHomePages): ServiceResult<TMobileBusinessObject> {
        response.apply {

            response.let {
                return ServiceResult.Success(it)
            }

            return ServiceResult.Error(Exception())
        }
    }

}