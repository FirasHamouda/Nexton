package com.nexton.nextonprojet.data.model

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName

data class Bannerinfo(
        @Nullable @SerializedName("type") val type: String,
        @Nullable @SerializedName("value") val value: String,
        @Nullable @SerializedName("color") val color: String
)
