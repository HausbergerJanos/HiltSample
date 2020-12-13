package com.hausberger.hiltsample.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.hausberger.hiltsample.R
import com.hausberger.hiltsample.model.Blog
import com.hausberger.hiltsample.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import java.lang.StringBuilder

@AndroidEntryPoint
class MainFragment
constructor(
        private val someString: String
) : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeObservers()
        viewModel.setStateEvent(MainStateEvent.GetBlogEvent)
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            when(dataState) {
                is DataState.Success<List<Blog>> -> {
                    displayProgressBar(false)
                    appendBlogTitles(dataState.data)
                }

                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }

                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })
    }

    private fun displayError(message: String?) {
        message?.let { safeMessage ->
            text.text = safeMessage
        }
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        progress_bar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }

    private fun appendBlogTitles(blogs: List<Blog>) {
        val sb = StringBuilder()
        blogs.forEach {
            sb.append(it.title + "\n")
        }
        text.text = sb.toString()
    }
}