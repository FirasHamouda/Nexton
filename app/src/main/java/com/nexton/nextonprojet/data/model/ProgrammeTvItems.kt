package com.nexton.nextonprojet.data.model

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName


data class ProgrammeTvItems(

    @Nullable @SerializedName("title")
    val title: List<ProgammeTVTitle>,
    @Nullable @SerializedName("subtitle")
    val subtitle: String,
    @Nullable @SerializedName("subtitlefocus")
    val subtitlefocus: List<String>,
    @Nullable @SerializedName("highlefticon")
    val highlefticon: String,
    @Nullable @SerializedName("highrighticon")
    val highrighticon: String,
    @Nullable @SerializedName("lowrightinfo")
    val lowrightinfo: String,
    @Nullable @SerializedName("imageurl")
    val imageurl: String,
    @Nullable @SerializedName("fullscreenimageurl")
    val fullscreenimageurl: String,
    @Nullable @SerializedName("id")
    val id: String,
    @Nullable @SerializedName("detaillink")
    val detaillink: String,
    @Nullable @SerializedName("duration")
    val duration: String,
    @Nullable @SerializedName("playinfoid")
    val playinfoid: Playinfoid
)
