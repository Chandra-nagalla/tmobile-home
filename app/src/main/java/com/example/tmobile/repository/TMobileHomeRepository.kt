package com.example.tmobile.repository

import com.example.tmobile.model.TMobileBusinessObject
import com.example.tmobile.service.ServiceResult

interface TMobileHomeRepository {
    suspend fun fetchTMobileHomePages(): ServiceResult<TMobileBusinessObject>
}