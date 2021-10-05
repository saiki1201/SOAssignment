package com.example.soassignment.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.soassignment.R
import com.example.soassignment.fragment.AnswerListFragment
import com.example.soassignment.fragment.QuestionListFragment
import com.example.soassignment.utils.parseHtml
import com.example.soassignment.viewmodel.QuestionListViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupActionBar(true)
        loadFragment(R.id.container, QuestionListFragment.newInstance())

        setupObservers()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            setupActionBar(true)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        setupActionBar(true)
    }

    private fun setupActionBar(isHome: Boolean, title: String? = null) {
        supportActionBar?.let {
            it.title = title ?: getString(R.string.stackoverflow)
            it.setDisplayHomeAsUpEnabled(!isHome)
            it.setDisplayShowHomeEnabled(isHome)
            it.setDisplayUseLogoEnabled(isHome)
        }
    }

    private fun setupObservers() {
        ViewModelProvider(this).get(QuestionListViewModel::class.java).apply {
            mutableLiveData.observe(this@MainActivity, {
                loadFragment(R.id.container, AnswerListFragment.newInstance(it), false)
                setupActionBar(false, it.title?.parseHtml().orEmpty())
            })
        }
    }

    private fun loadFragment(container: Int, fragment: Fragment, replace: Boolean = true) {
        if (replace)
            this
                .supportFragmentManager
                .beginTransaction()
                .replace(container, fragment)
                .commit()
        else
            this
                .supportFragmentManager
                .beginTransaction()
                .addToBackStack(fragment.tag)
                .add(container, fragment)
                .commit()
    }
}