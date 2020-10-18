package com.example.firstkotlinmsgshare

import android.content.Context
import android.widget.Toast

fun Context.ShowToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}