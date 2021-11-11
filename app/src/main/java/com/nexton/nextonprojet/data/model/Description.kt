package com.nexton.nextonprojet.data.model


import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName

data class Description(
        @Nullable @SerializedName("description") val description : List<String>

)
