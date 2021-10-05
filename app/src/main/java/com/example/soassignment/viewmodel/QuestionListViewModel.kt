package com.example.soassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.soassignment.model.QuestionResponse
import com.example.soassignment.model.ResponseItem
import com.example.soassignment.network.RetrofitObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class QuestionListViewModel : ViewModel() {

    private val _questions: MutableLiveData<List<ResponseItem>> =
        MutableLiveData()
    val questions: MutableLiveData<List<ResponseItem>> =
        _questions

    private val _error: MutableLiveData<Throwable> = MutableLiveData()
    val error: MutableLiveData<Throwable> = _error

    val isLoadingMutableLiveData: MutableLiveData<Boolean> = MutableLiveData()

    val mutableLiveData: MutableLiveData<ResponseItem> = MutableLiveData()

    var mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    fun fetchQuestions() {
        isLoadingMutableLiveData.postValue(true)
        mCompositeDisposable.add(
            RetrofitObject.getClient().getAllQuestions()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ response -> handleResponse(response) }, { t -> handleError(t) })
        )
    }

    private fun handleResponse(questions: QuestionResponse) {
        isLoadingMutableLiveData.postValue(false)
        _questions.postValue(questions.items)
    }

    private fun handleError(error: Throwable) {
        isLoadingMutableLiveData.postValue(false)
        _error.postValue(error)
    }

}