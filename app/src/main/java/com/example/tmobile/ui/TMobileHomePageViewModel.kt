package com.example.tmobile.ui

import androidx.lifecycle.LiveData
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
    private var _tMobileHomePageData = MutableLiveData<TMobileHomePages>()
    val tMobileHomePageData : LiveData<TMobileHomePages> = _tMobileHomePageData

    fun init(tMobileHomeRepository: TMobileHomeRepository) {
        this.tMobileHomePageRepository = tMobileHomeRepository
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
                    _tMobileHomePageData.value = response
                }
            }
        }
    }
}