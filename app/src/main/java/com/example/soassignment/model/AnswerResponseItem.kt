package com.example.soassignment.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AnswerResponseItem(
    val reputation: Long? = null,
    @SerializedName("user_id")
    val userId: Long? = null,
    @SerializedName("user_type")
    val userType: String? = null,
    @SerializedName("accept_rate")
    val acceptRate: Long? = null,
    @SerializedName("profile_image")
    val profileImage: String? = null,
    @SerializedName("display_name")
    val displayName: String? = null,
    val link: String? = null
) : Parcelable
