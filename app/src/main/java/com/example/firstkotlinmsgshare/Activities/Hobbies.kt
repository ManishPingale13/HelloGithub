package com.example.firstkotlinmsgshare.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstkotlinmsgshare.Adapters.HobbiesAdapter
import com.example.firstkotlinmsgshare.Models.Supplier
import com.example.firstkotlinmsgshare.R
import kotlinx.android.synthetic.main.activity_hobbies.*

class Hobbies : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        setuprecyclerview()
    }

    private fun setuprecyclerview() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val adapter = HobbiesAdapter(this, Supplier.hobbies)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
    }
}