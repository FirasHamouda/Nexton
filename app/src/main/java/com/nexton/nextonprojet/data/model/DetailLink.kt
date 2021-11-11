package com.nexton.nextonprojet.data.model

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName

data class DetailLink(
        @Nullable @SerializedName("template")
        val template : String,
        @Nullable @SerializedName("parentalrating")
        val parentalrating : Int,
        @Nullable @SerializedName("categoryID")
        val categoryID : Int,
        @Nullable @SerializedName("contents")
        val contents : Contents

)
