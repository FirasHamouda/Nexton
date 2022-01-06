package com.nexton.nextonprojet.data.model

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName

data class ProgrammeTV(

    @Nullable @SerializedName("template")
    val template: String,
    @Nullable @SerializedName("parentalrating")
    val parentalrating: Long,
    @Nullable @SerializedName("title")
    val title: String,
    @Nullable @SerializedName("offset")
    val offset: Long,
    @Nullable @SerializedName("limit")
    val limit: String,
    @Nullable @SerializedName("next")
    val next: Any? = null,
    @Nullable @SerializedName("previous")
    val previous: Any? = null,
    @Nullable @SerializedName("total")
    val total: Long,
    @Nullable @SerializedName("count")
    val count: Long,
    @Nullable @SerializedName("filter")
    val filter: Any? = null,
    @Nullable @SerializedName("sort")
    val sort: Any? = null,
    @Nullable @SerializedName("contents")
    val contents: List<ProgrammeTvItems>


)
