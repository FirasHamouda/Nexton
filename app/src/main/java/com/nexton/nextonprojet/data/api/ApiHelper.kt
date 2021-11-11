package com.nexton.nextonprojet.data.api

class ApiHelper (private val apiService: ApiService) {

    fun getProgrammeTV(key : String) = apiService.getProgrammeTV(key)

    fun getPitch(detailLink: String) = apiService.getPitch(detailLink)


}