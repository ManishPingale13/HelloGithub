package com.example.firstkotlinmsgshare.Utils

import android.content.Context
import android.widget.Toast

fun Context.ShowToast(message: String , duration : Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}
