package com.example.soassignment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.soassignment.R
import com.example.soassignment.databinding.FragmentAnswerListBinding
import com.example.soassignment.model.ResponseItem
import com.example.soassignment.recyclerviewadapter.AnswerListRecyclerViewAdapter
import com.example.soassignment.viewmodel.AnswerListViewModel

class AnswerListFragment : Fragment() {

    private val answerListRecyclerViewAdapter by lazy {
        AnswerListRecyclerViewAdapter()
    }

    private lateinit var fragmentAnswerListBinding: FragmentAnswerListBinding
    private lateinit var responseItem: ResponseItem

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentAnswerListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_answer_list, container, false)
        arguments?.getParcelable<ResponseItem>(PARAM_RESPONSE_ITEM)?.let {
            responseItem = it
            fragmentAnswerListBinding.answerListViewModel = AnswerListViewModel(responseItem)
            fragmentAnswerListBinding.lifecycleOwner = this
        }
        return fragmentAnswerListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        fragmentAnswerListBinding.rvAnswers.adapter = answerListRecyclerViewAdapter
        answerListRecyclerViewAdapter.setData(responseItem.answers.orEmpty())
        fragmentAnswerListBinding.rvAnswers.isNestedScrollingEnabled = false
    }

    companion object {
        private const val PARAM_RESPONSE_ITEM = "responseItem"
        fun newInstance(responseItem: ResponseItem) = AnswerListFragment().apply {
            this.arguments = bundleOf(
                PARAM_RESPONSE_ITEM to responseItem
            )
        }
    }
}