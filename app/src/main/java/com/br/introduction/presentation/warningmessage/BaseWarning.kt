package com.br.introduction.presentation.warningmessage

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import com.br.introduction.R
import com.br.introduction.presentation.Animations.AnimationUtils
import kotlinx.android.synthetic.main.warning_base.view.*


open class BaseWarning constructor(context: Context) {

    private lateinit var popUpWindows: PopupWindow
    private val numberZero = 0
    private val animationUtils = AnimationUtils()
    val rootView = getActivity(context)!!.window.decorView.findViewById<View>(android.R.id.content) as ViewGroup
    val view = LayoutInflater.from(context).inflate(R.layout.warning_base, rootView, false)

    fun configure(icon: Int, title: String, description: String) {
        view.icon.setImageResource(icon)
        view.title.text = title
        view.description.text = description
        view.containerTitleDecription.contentDescription = "$title $description"
    }

    fun contentDescriptionWindows(string: String) {
        view.icon.contentDescription = string
    }

    fun show(): BaseWarning {
        popUpWindows = PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        popUpWindows.showAtLocation(rootView, Gravity.CENTER, numberZero, numberZero)
        popUpWindows.isFocusable = true
        popUpWindows.update()
        animationIn()
        return this
    }

    fun animationIn() {
        animationUtils.slideUp(popUpWindows.contentView)
        val fadeIn = android.view.animation.AnimationUtils.loadAnimation(rootView.context, R.anim.fade_in)
        fadeIn.startOffset = 400
        view.backgroundView.startAnimation(fadeIn)
    }

    fun dismiss() {
        view.backgroundView.clearAnimation()
        view.backgroundView.visibility = View.GONE
        animationUtils.slideDown(popUpWindows.contentView) {
            popUpWindows.dismiss()
        }
    }

    private fun getActivity(mContext: Context): Activity? {
        var context = mContext
        while (context is ContextWrapper) {
            if (context is Activity) {
                return context
            }
            context = (context as ContextWrapper).baseContext
        }
        return null
    }
}