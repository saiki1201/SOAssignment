package com.example.soassignment.recyclerviewadapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.soassignment.R
import com.example.soassignment.databinding.AnswersListRecyclerviewItemBinding
import com.example.soassignment.model.AnswerItem
import com.example.soassignment.viewmodel.AnswerListItemViewModel

class AnswerListRecyclerViewAdapter :
    RecyclerView.Adapter<AnswerListRecyclerViewAdapter.MyViewHolder>() {

    private val answers: MutableList<AnswerItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val answersRecyclerViewItemLayoutBinding: AnswersListRecyclerviewItemBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.answers_list_recyclerview_item,
                parent,
                false
            )
        return MyViewHolder(answersRecyclerViewItemLayoutBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItemView(answers[position], AnswerListItemViewModel(answers[position]))
    }

    override fun getItemCount() = answers.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(answers: List<AnswerItem>) {
        with(this.answers) {
            clear()
            addAll(answers)
        }
        notifyDataSetChanged()
    }

    inner class MyViewHolder(private val answersRecyclerViewItemLayoutBinding: AnswersListRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(answersRecyclerViewItemLayoutBinding.root) {
        fun bindItemView(answer: AnswerItem, answerListItemViewModel: AnswerListItemViewModel) {
            answersRecyclerViewItemLayoutBinding.answerListItemViewModel =
                answerListItemViewModel
            markAcceptedAnswer(answer)
        }

        private fun markAcceptedAnswer(answer: AnswerItem) {
            with(itemView.findViewById<TextView>(R.id.tvAnswer)) {
                setCompoundDrawablesWithIntrinsicBounds(
                    if (answer.isAccepted == true) R.drawable.ic_check_circle_outline else 0,
                    0,
                    0,
                    0
                )
            }
        }
    }

}