package com.example.soassignment.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AnswerItem(
    val tags: ArrayList<String>? = null,
    val answer: AnswerResponseItem? = null,
    @SerializedName("is_accepted")
    val isAccepted: Boolean? = null,
    val score: Long? = null,
    @SerializedName("last_activity_date")
    val lastActivityDate: Long? = null,
    @SerializedName("creation_date")
    val creationDate: Long? = null,
    @SerializedName("last_edit_date")
    val lastEditDate: Long? = null,
    @SerializedName("answer_id")
    val answerId: Long? = null,
    @SerializedName("question_id")
    val questionId: Long? = null,
    val link: String? = null,
    val title: String? = null,
    val body: String? = null
) : Parcelable
