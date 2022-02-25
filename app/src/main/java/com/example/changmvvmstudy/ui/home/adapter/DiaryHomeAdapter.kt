package com.example.changmvvmstudy.ui.home.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.changmvvmstudy.data.DiaryData
import com.example.changmvvmstudy.databinding.DiaryItemBinding
import com.example.changmvvmstudy.ui.editDiary.EditDiaryActivity

class DiaryHomeAdapter : ListAdapter<DiaryData, DiaryHomeAdapter.DiaryHomeViewHolder>(
    diaryHomeDiffUtil
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaryHomeViewHolder {
        val binding = DiaryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return DiaryHomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DiaryHomeViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    fun updateDiaryList(DiaryList: List<DiaryData>) {
        submitList(DiaryList)
    }

    class DiaryHomeViewHolder(private val binding: DiaryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: DiaryData) {
            binding.diaryData = data
        }

        init {
            itemView.setOnClickListener {
                val intent = Intent(it.context, EditDiaryActivity::class.java)
                startActivity(it.context, intent, null)
            }
        }
    }

    companion object {
        private val diaryHomeDiffUtil = object : DiffUtil.ItemCallback<DiaryData>() {
            override fun areItemsTheSame(oldItem: DiaryData, newItem: DiaryData): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: DiaryData, newItem: DiaryData): Boolean =
                oldItem == newItem
        }
    }
}