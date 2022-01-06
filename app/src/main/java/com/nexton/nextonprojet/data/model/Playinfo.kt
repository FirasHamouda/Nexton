package com.nexton.nextonprojet.data.model

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName

data class Playinfo(
        @Nullable @SerializedName("tokenurl") val tokenurl: String,
        @Nullable @SerializedName("url") val url: String
)
