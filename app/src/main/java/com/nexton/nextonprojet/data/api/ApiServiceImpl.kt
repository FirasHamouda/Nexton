package com.nexton.nextonprojet.data.api

import com.nexton.nextonprojet.data.model.DetailLink
import com.nexton.nextonprojet.data.model.ProgrammeTV

import com.nexton.nextonprojet.utils.URLConstants
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

class ApiServiceImpl : ApiService {

    override fun getProgrammeTV(key: String): Single<ProgrammeTV> {

        return Rx2AndroidNetworking.get(URLConstants.URL_SEARCH + key)
            .build()
            .getObjectSingle(ProgrammeTV::class.java)
    }

    override fun getPitch(detailLink: String): Single<DetailLink> {
        return Rx2AndroidNetworking.get(URLConstants.URL_PITCH + detailLink)
            .build()
            .getObjectSingle(DetailLink::class.java)
    }

}