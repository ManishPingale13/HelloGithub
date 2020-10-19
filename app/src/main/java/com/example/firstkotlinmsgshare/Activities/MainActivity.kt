package com.example.firstkotlinmsgshare.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstkotlinmsgshare.R
import com.example.firstkotlinmsgshare.Utils.ShowToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mname: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            mname = edittext.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("name",mname)
            startActivity(intent)
            ShowToast("This is a Toast msg")
        }

        share.setOnClickListener {
            mname = edittext.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,mname)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent,"Share to:"))
        }

        btnrecycler.setOnClickListener {
            val intent = Intent(this, Hobbies::class.java)
            startActivity(intent)
        }
    }
}
