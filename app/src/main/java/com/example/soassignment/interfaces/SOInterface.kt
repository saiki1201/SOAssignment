package com.example.soassignment.interfaces

import com.example.soassignment.BuildConfig
import com.example.soassignment.model.OrderType
import com.example.soassignment.model.QuestionResponse
import com.example.soassignment.model.SortType
import com.example.soassignment.network.Config.CONTAINS_ACCEPTED
import com.example.soassignment.network.Config.FETCH_ALL_QUESTIONS
import com.example.soassignment.network.Config.MIN_ANSWER
import com.example.soassignment.network.Config.SITE
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface SOInterface {

    @GET(FETCH_ALL_QUESTIONS)
    fun getAllQuestions(
        @Query("accepted") accepted: Boolean = CONTAINS_ACCEPTED,
        @Query("answers") answers: Int = MIN_ANSWER,
        @Query("filter") filter: String = BuildConfig.SO_API,
        @Query("order") order: String = OrderType.DESC.name.lowercase(Locale.getDefault()),
        @Query("site") site: String = SITE,
        @Query("sort") sort: String = SortType.ACTIVITY.name.lowercase(Locale.getDefault())
    ): Observable<QuestionResponse>

}