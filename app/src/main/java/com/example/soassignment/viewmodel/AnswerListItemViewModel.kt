package com.example.soassignment.viewmodel

import androidx.lifecycle.ViewModel
import com.example.soassignment.model.AnswerItem
import com.example.soassignment.utils.parseHtml

class AnswerListItemViewModel(private val answerItem: AnswerItem) :
    ViewModel() {
    val body: String
        get() = answerItem.body?.parseHtml().orEmpty()
}
