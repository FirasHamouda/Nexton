package com.nexton.nextonprojet.data.model

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName

data class Playinfoid(
        @Nullable @SerializedName("sd") val sd : String,
        @Nullable @SerializedName("hd") val hd : String,
        @Nullable @SerializedName("uhd") val uhd : String
)
