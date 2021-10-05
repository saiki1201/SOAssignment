package com.example.soassignment.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseItem(
    val tags: ArrayList<String>? = null,
    val answer: AnswerResponseItem? = null,
    @SerializedName("is_answered")
    val isAnswered: Boolean? = null,
    @SerializedName("view_count")
    val viewCount: Long? = null,
    @SerializedName("closed_date")
    val closedDate: Long? = null,
    @SerializedName("answer_count")
    val answerCount: Long? = null,
    val score: Long? = null,
    @SerializedName("last_activity_date")
    val lastActivityDate: Long? = null,
    @SerializedName("creation_date")
    val creationDate: Long? = null,
    @SerializedName("last_edit_date")
    val lastEditDate: Long? = null,
    @SerializedName("question_id")
    val questionId: Long? = null,
    val link: String? = null,
    @SerializedName("closed_reason")
    val closedReason: String? = null,
    val title: String? = null,
    val body: String? = null,
    val answers: ArrayList<AnswerItem>? = null
) : Parcelable