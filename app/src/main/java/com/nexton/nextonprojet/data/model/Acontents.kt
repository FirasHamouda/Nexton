package com.nexton.nextonprojet.data.model

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName

data class Acontents(
        @Nullable @SerializedName("type") val type : String,
        @Nullable @SerializedName("description") val description : List<Description>,
        @Nullable @SerializedName("link") var link : String,
        @Nullable @SerializedName("imageurl") val imageurl : String,
        @Nullable @SerializedName("contents") val contents : List<Contents>
)
