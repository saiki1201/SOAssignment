package com.example.soassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.soassignment.model.ResponseItem
import com.example.soassignment.utils.parseHtml

class AnswerListViewModel(private val responseItem: ResponseItem) : ViewModel() {

    val title: MutableLiveData<String>
        get() = MutableLiveData(responseItem.title?.parseHtml().orEmpty())

    val body: MutableLiveData<String>
        get() = MutableLiveData(responseItem.body?.parseHtml().orEmpty())

}
