package com.example.changmvvmstudy.ui.home

import android.os.Bundle
import android.widget.ListAdapter
import com.example.changmvvmstudy.R
import com.example.changmvvmstudy.data.DiaryData
import com.example.changmvvmstudy.databinding.ActivityDiaryHomeBinding
import com.example.changmvvmstudy.ui.base.BaseActivity
import com.example.changmvvmstudy.ui.home.adapter.DiaryHomeAdapter
import java.util.*

class DiaryHomeActivity : BaseActivity<ActivityDiaryHomeBinding>(R.layout.activity_diary_home) {

    private lateinit var diaryHomeAdapter: DiaryHomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initAdapter()
    }

    private fun initAdapter(){
        diaryHomeAdapter = DiaryHomeAdapter()
        binding.rvDiaryHome.adapter = diaryHomeAdapter
        diaryHomeAdapter.updateDiaryList(STUB_DIARIES)
    }

    companion object {
        val STUB_DIARIES = listOf(
            DiaryData(0, "1번", "내용", Date()),
            DiaryData(1, "2번", "내용", Date()),
            DiaryData(2, "3번", "내용", Date()),
            DiaryData(3, "4번", "내용", Date()),
            DiaryData(4, "5번", "내용", Date()),
        )
    }
}