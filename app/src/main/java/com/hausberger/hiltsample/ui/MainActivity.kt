package com.hausberger.hiltsample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hausberger.hiltsample.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var fragmentFactory: MainFragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.fragmentFactory = fragmentFactory
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, MainFragment::class.java, null)
                .commit()
    }
}