package com.example.soassignment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.soassignment.R
import com.example.soassignment.databinding.FragmentQuestionListBinding
import com.example.soassignment.interfaces.OnQuestionSelectedListener
import com.example.soassignment.model.ResponseItem
import com.example.soassignment.recyclerviewadapter.QuestionListRecyclerViewAdapter
import com.example.soassignment.viewmodel.QuestionListViewModel

class QuestionListFragment : Fragment(), OnQuestionSelectedListener {

    private val questionListRecyclerViewAdapter by lazy {
        QuestionListRecyclerViewAdapter(this)
    }
    private val questionListViewModel by lazy {
        ViewModelProvider(requireActivity()).get(QuestionListViewModel::class.java)
    }
    private lateinit var fragmentQuestionListBinding: FragmentQuestionListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentQuestionListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_question_list, container, false)
        fragmentQuestionListBinding.lifecycleOwner = this
        return fragmentQuestionListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObservers()
    }

    override fun onResume() {
        super.onResume()
        fetchLatestQuestions()
    }

    private fun fetchLatestQuestions() {
        questionListViewModel.fetchQuestions()
    }

    private fun setupViews() {
        fragmentQuestionListBinding.rvQuestions.adapter = questionListRecyclerViewAdapter
    }

    private fun setupObservers() {
        questionListViewModel.questions.observe(requireActivity(), {
            questionListRecyclerViewAdapter.setData(it)
        })

        questionListViewModel.error.observe(requireActivity(), {
            showToast(getString(R.string.error))
        })

        questionListViewModel.isLoadingMutableLiveData.observe(requireActivity(), {
            if (it) {
                fragmentQuestionListBinding.pb1.visibility = View.VISIBLE
            } else {
                fragmentQuestionListBinding.pb1.visibility = View.GONE
            }
        })
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        questionListViewModel.mCompositeDisposable.dispose()
    }

    override fun questionClicked(item: ResponseItem) {
        questionListViewModel.mutableLiveData.postValue(item)
    }

    companion object {
        fun newInstance() = QuestionListFragment()
    }
}