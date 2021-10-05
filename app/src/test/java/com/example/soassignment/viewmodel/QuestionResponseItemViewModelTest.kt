package com.example.soassignment.viewmodel

import com.example.soassignment.model.ResponseItem
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class QuestionResponseItemViewModelTest {
    private lateinit var questionResponseItemViewModel: QuestionResponseItemViewModel
    private lateinit var responseItem: ResponseItem

    @Before
    fun setup() {
        responseItem = ResponseItem(
            title = "title"
        )
        questionResponseItemViewModel = QuestionResponseItemViewModel(responseItem)
    }

    @Test
    fun `title should return html parsed string`() {
        Assert.assertEquals("title", questionResponseItemViewModel.title)
    }
}