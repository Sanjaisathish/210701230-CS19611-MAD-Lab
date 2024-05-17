MyCustomView.kt :

package com.example.graphicalprimitives

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyCustomView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val paint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.FILL
        color = Color.BLACK
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw Circle
        paint.color = Color.RED
        canvas.drawCircle(200f, 200f, 100f, paint)

        // Draw Ellipse
        paint.color = Color.GREEN
        canvas.drawOval(100f, 400f, 300f, 600f, paint)

        // Draw Rectangle
        paint.color = Color.BLUE
        canvas.drawRect(100f, 700f, 300f, 900f, paint)

        // Draw Text
        paint.color = Color.BLACK
        paint.textSize = 50f
        canvas.drawText("Hello, World!", 100f, 1100f, paint)
    }
}

activity_main.xml:

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <com.example.graphicalprimitives.MyCustomView
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
</RelativeLayout>

MainActivity.kt:

package com.example.graphicalprimitives

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
