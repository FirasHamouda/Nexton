package com.nexton.nextonprojet.data.model

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName

data class Zonesinfo(
        @Nullable @SerializedName("duration") val duration : Int,
        @Nullable @SerializedName("endcreditsautocompleted") val endcreditsautocompleted : Boolean,
        @Nullable @SerializedName("previouslytcin") val previouslytcin : String,
        @Nullable @SerializedName("previouslytcout") val previouslytcout : String,
        @Nullable @SerializedName("startcreditstcin") val startcreditstcin : String,
        @Nullable @SerializedName("startcreditstcout") val startcreditstcout : String,
        @Nullable @SerializedName("endcreditstcin") val endcreditstcin : Int,
        @Nullable @SerializedName("endcreditstcout") val endcreditstcout : Int
)
