package com.rpone.torch

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        textView = TextView(this).apply {
            text = "点击打开"
            textSize = 24f
            setTextColor(Color.WHITE)
            textAlignment = View.TEXT_ALIGNMENT_CENTER
            gravity = Gravity.CENTER
        }

        setContentView(textView)
        textView.setBackgroundColor(Color.BLACK)

        // 设置保持屏幕亮度
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        textView.setOnClickListener {
            if (textView.text.isNotEmpty()) {
                textView.text = ""
                textView.setBackgroundColor(Color.WHITE)
            } else {
                textView.text = "点击打开"
                textView.setBackgroundColor(Color.BLACK)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        // 设置亮度为最大
        window.attributes = window.attributes.apply { screenBrightness = 1f }
        // 切换到黑屏
        textView.text = "点击打开"
        textView.setBackgroundColor(Color.BLACK)
    }

    override fun onPause() {
        super.onPause()
        // 恢复默认亮度
        window.attributes = window.attributes.apply { screenBrightness = WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_NONE }
    }
}
