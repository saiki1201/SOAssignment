package com.example.soassignment.viewmodel

import androidx.lifecycle.ViewModel
import com.example.soassignment.model.ResponseItem
import com.example.soassignment.utils.parseHtml

class QuestionResponseItemViewModel(private val responseItem: ResponseItem) :
    ViewModel() {
    val title: String
        get() = responseItem.title?.parseHtml().orEmpty()
}