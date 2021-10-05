package com.example.soassignment.viewmodel

import com.example.soassignment.model.ResponseItem
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AnswerListViewModelTest {
    private lateinit var answerListViewModel: AnswerListViewModel
    private lateinit var responseItem: ResponseItem

    @Before
    fun setup() {
        responseItem = ResponseItem(
            title = "title",
            body = "Sample text"
        )
        answerListViewModel = AnswerListViewModel(responseItem)
    }

    @Test
    fun `title should return html parsed string`() {
        Assert.assertEquals("title", answerListViewModel.title)
    }

    @Test
    fun `body should return html parsed string`() {
        Assert.assertEquals("Sample text", answerListViewModel.body)
    }
}