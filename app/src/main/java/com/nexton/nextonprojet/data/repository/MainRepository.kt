package com.nexton.nextonprojet.data.repository

import com.nexton.nextonprojet.data.api.ApiHelper
import com.nexton.nextonprojet.data.model.DetailLink
import com.nexton.nextonprojet.data.model.ProgrammeTV
import io.reactivex.Single

class MainRepository (private val apiHelper: ApiHelper){

    fun getProgrammeTV(key: String): Single<ProgrammeTV> {
        return apiHelper.getProgrammeTV(key)
    }

    fun getPitch(detailLink :String): Single<DetailLink> {
        return apiHelper.getPitch(detailLink)
    }
}