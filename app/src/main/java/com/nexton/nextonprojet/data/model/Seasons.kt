package com.nexton.nextonprojet.data.model

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName

data class Seasons(
        @Nullable @SerializedName("menutitle") val menutitle: List<Title>,
        @Nullable @SerializedName("subtitle") val subtitle: String,
        @Nullable @SerializedName("number") val number: Int,
        @Nullable @SerializedName("id") val id: String,
        @Nullable @SerializedName("pitch") val pitch: String,
        @Nullable @SerializedName("imageurl") val imageurl: String,
        @Nullable @SerializedName("isbookmarkable") val isbookmarkable: Boolean,
        @Nullable @SerializedName("episodes") val episodes: List<Episodes>,
        @Nullable @SerializedName("highlefticon") val highlefticon: List<String>,
        @Nullable @SerializedName("acontents") val acontents: List<Acontents>
)

