package com.example.firstkotlinmsgshare.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstkotlinmsgshare.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        intent.extras?.let {
            textview.text = getString(R.string.hello) + " ${intent.extras?.getString("name")}!\""
        }
    }
}