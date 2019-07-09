package com.example.presentation.ui.view.toast

import android.content.Context
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.R

/**
 *  Author : JinTao Li
 *  Create Time : 2019/7/9
 */
class ToastView(private var context: Context) : Toast(context) {

    companion object {
        private const val TOAST_TYPEFACE = "sans-serif-condensed"
    }

    init {
        initToastView()
    }

    private lateinit var textView: TextView
    private var oneTime: Long = 0L
    private var twoTime: Long = 0L
    private var oldMsg: String? = null
    private fun initToastView() {
        val view = View.inflate(context, R.layout.toast_layout, null)
        textView = view.findViewById(R.id.tv_toast)
        setView(view)
//        setGravity(Gravity.BOTTOM, 0, 0)
        duration = LENGTH_SHORT
        oneTime = System.currentTimeMillis()
    }

    fun showToast(message: String?) {
        twoTime = System.currentTimeMillis()
        if (message == oldMsg && twoTime - oneTime > LENGTH_SHORT) {
            show()
        } else {
            oldMsg = message
            textView.text = message
            textView.typeface = Typeface.create(TOAST_TYPEFACE, Typeface.NORMAL)
            show()
        }
        oneTime = twoTime
    }
}