package com.nexton.nextonprojet.data.model

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName

data class Episodes(
        @Nullable @SerializedName("parentalrating") var parentalrating : Int,
        @Nullable @SerializedName("isbookmarkable") var isbookmarkable : Boolean,
        @Nullable @SerializedName("isdownloadable") var isdownloadable : Boolean,
        @Nullable @SerializedName("number") var number : Int,
        @Nullable @SerializedName("title") var title : List<Title>,
        @Nullable @SerializedName("duration") var duration : String,
        @Nullable @SerializedName("availability") var availability : List<Title>,
        @Nullable @SerializedName("menutitle") var menutitle : List<Title>,
        @Nullable @SerializedName("menutitlefocus") var menutitlefocus : List<Title>,
        @Nullable @SerializedName("summary") var summary : String,
        @Nullable @SerializedName("highlefticon") var highlefticon : List<String>,
        @Nullable @SerializedName("highrighticon") var highrighticon : String,
        @Nullable @SerializedName("subtitle") var subtitle : String,
        @Nullable @SerializedName("subtitlefocus") var subtitlefocus : String,
        @Nullable @SerializedName("pitch") var pitch : String,
        @Nullable @SerializedName("bannerinfo") var bannerinfo : List<Bannerinfo>,
        @Nullable @SerializedName("description") var description : List<List<String>>,
        @Nullable @SerializedName("imageurl") var imageurl : String,
        @Nullable @SerializedName("fullscreenimageurl") var fullscreenimageurl : String,
        @Nullable @SerializedName("linearplanning") var linearplanning : String,
        @Nullable @SerializedName("acontents") var acontents : List<Acontents>,
        @Nullable @SerializedName("playinfoid") var playinfoid : Playinfoid,
        @Nullable @SerializedName("playinfo") var playinfo : Playinfo,
        @Nullable @SerializedName("id") var id : String,
        @Nullable @SerializedName("zonesinfo") var zonesinfo : Zonesinfo
)
