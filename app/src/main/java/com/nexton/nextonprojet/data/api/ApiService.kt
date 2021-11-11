package com.nexton.nextonprojet.data.api


import com.nexton.nextonprojet.data.model.DetailLink
import com.nexton.nextonprojet.data.model.ProgrammeTV
import io.reactivex.Single

interface ApiService {

    fun getProgrammeTV(key: String): Single<ProgrammeTV>


    fun getPitch(detailLink: String): Single<DetailLink>
}