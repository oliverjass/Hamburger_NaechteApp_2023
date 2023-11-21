package com.example.myapplication.utils

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.example.myapplication.R

object Utils {


                                                                                                    // Grafisches Ladeindikator um zu zeigen das, das laden im gange ist.um visuell anzuzeigen, dass eine Aktion im Gange ist, z. B. wenn Daten geladen werden.
    fun createCircularProgressDrawable(context: Context): CircularProgressDrawable {
        return CircularProgressDrawable(context).apply {
            this.strokeWidth = 5f
            this.centerRadius = 100f
            this.setColorSchemeColors(
                context.getColor(R.color.hnblue2),
                context.getColor(R.color.white)
            )
            this.start()
        }
    }
}