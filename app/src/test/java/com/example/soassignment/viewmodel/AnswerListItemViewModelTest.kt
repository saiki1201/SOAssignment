package com.example.soassignment.viewmodel

import com.example.soassignment.model.AnswerItem
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AnswerListItemViewModelTest {

    private lateinit var answerListItemViewModel: AnswerListItemViewModel
    private lateinit var answerItem: AnswerItem

    @Before
    fun setup() {
        answerItem = AnswerItem(
            body = "Sample text"
        )
        answerListItemViewModel = AnswerListItemViewModel(answerItem)
    }

    @Test
    fun `body should return html parsed string`() {
        Assert.assertEquals("Sample text", answerListItemViewModel.body)
    }
}
