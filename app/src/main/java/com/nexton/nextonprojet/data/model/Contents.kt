package com.nexton.nextonprojet.data.model

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName

data class Contents(

        @Nullable @SerializedName("parentalrating") var parentalrating : Int,
        @Nullable @SerializedName("isbookmarkable") var isbookmarkable : Boolean,
        @Nullable @SerializedName("isdownloadable") var isdownloadable : Boolean,
        @Nullable @SerializedName("number") var number : String,
        @Nullable @SerializedName("title") var title : List<Title>,
        @Nullable @SerializedName("duration") var duration : String,
        @Nullable @SerializedName("availability") var availability : List<Title>,
        @Nullable @SerializedName("summary") var summary : String,
        @Nullable @SerializedName("highlefticon") var highlefticon : Any,
        @Nullable @SerializedName("highrighticon") var highrighticon : Any,
        @Nullable @SerializedName("subtitle") var subtitle : Any,
        @Nullable @SerializedName("subtitlefocus") var subtitlefocus : Any,
        @Nullable @SerializedName("pitch") var pitch : String,
        @Nullable @SerializedName("bannerinfo") var bannerinfo : List<Title>,
        @Nullable @SerializedName("imageurl") var imageurl : String,
        @Nullable @SerializedName("fullscreenimageurl") var fullscreenimageurl : String,
        @Nullable @SerializedName("linearplanning") var linearplanning : Any,
        @Nullable @SerializedName("playinfoid") var playinfoid : Playinfoid,
        @Nullable @SerializedName("playinfo") var playinfo : Playinfo,
        @Nullable @SerializedName("id") var id : String,
        @Nullable @SerializedName("zonesinfo") var zonesinfo : Zonesinfo,
        @Nullable @SerializedName("highlightid") var highlightid : String,
        @Nullable @SerializedName("selectid") var selectid : String,
        @Nullable @SerializedName("detaillink") var detaillink : String,
        @Nullable @SerializedName("seasons") var seasons : List<Seasons>,
        @Nullable @SerializedName("acontents") var acontents : List<Acontents>

)
