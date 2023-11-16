package com.example.myapplication.utils

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.example.myapplication.R

object Utils {

    fun createCircularProgressDrawable(context: Context): CircularProgressDrawable {
        return CircularProgressDrawable(context).apply {
            this.strokeWidth = 5f
            this.centerRadius = 100f
            this.setColorSchemeColors(
                context.getColor(R.color.hnblue),
                context.getColor(R.color.white)
            )
            this.start()
        }
    }
}