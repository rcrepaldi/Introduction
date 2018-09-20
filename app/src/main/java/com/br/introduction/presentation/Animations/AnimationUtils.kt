package com.br.introduction.presentation.Animations

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View

class AnimationUtils {

    fun slideDown(view: View, callback: () -> Unit) {
        view.animate()
                .translationY(view.height.toFloat())
                .alpha(0f)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        view.visibility = View.GONE
                        view.alpha = 1f
                        view.translationY = 0f
                        callback()
                    }
                })
    }

    fun slideUp(view: View) {
        view.visibility = View.VISIBLE
        view.alpha = 0f

        if (view.height > 0) {
            slideUpNow(view)
        } else {
            view.post {
                slideUpNow(view)
            }
        }
    }

    private fun slideUpNow(view: View) {
        view.translationY = view.height.toFloat()
        view.animate()
                .translationY(0f)
                .alpha(1f)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        view.visibility = View.VISIBLE
                        view.alpha = 1f
                    }
                })
    }
}