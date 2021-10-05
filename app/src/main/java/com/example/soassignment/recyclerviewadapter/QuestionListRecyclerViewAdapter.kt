package com.example.soassignment.recyclerviewadapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.soassignment.R
import com.example.soassignment.databinding.QuestionListRecyclerviewItemBinding
import com.example.soassignment.interfaces.OnQuestionSelectedListener
import com.example.soassignment.model.ResponseItem
import com.example.soassignment.viewmodel.QuestionResponseItemViewModel

class QuestionListRecyclerViewAdapter(private val onQuestionSelectedListener: OnQuestionSelectedListener) :
    RecyclerView.Adapter<QuestionListRecyclerViewAdapter.MyViewHolder>() {

    private val questions: MutableList<ResponseItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val questionRecyclerViewItemLayoutBinding: QuestionListRecyclerviewItemBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.question_list_recyclerview_item,
                parent,
                false
            )

        return MyViewHolder(questionRecyclerViewItemLayoutBinding).apply {
            itemView.setOnClickListener {
                onQuestionSelectedListener.questionClicked(questions[adapterPosition])
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItemView(QuestionResponseItemViewModel(questions[position]))
    }

    override fun getItemCount() = questions.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(questions: List<ResponseItem>) {
        with(this.questions) {
            clear()
            addAll(questions)
        }
        notifyDataSetChanged()
    }

    inner class MyViewHolder(private val questionRecyclerViewItemLayoutBinding: QuestionListRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(questionRecyclerViewItemLayoutBinding.root) {
        fun bindItemView(questionResponseItemViewModel: QuestionResponseItemViewModel) {
            questionRecyclerViewItemLayoutBinding.questionResponseItemViewModel =
                questionResponseItemViewModel
        }
    }
}
