package com.br.introduction.presentation.intro.carousel

import android.databinding.BaseObservable
import android.databinding.BindingAdapter
import android.databinding.ObservableField
import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.br.introduction.R


class CarouselViewModel constructor(position: Int) : BaseObservable() {

    val icon: ObservableField<Int> = ObservableField()
    val title: ObservableField<Int> = ObservableField()
    val description: ObservableField<Int> = ObservableField()

    init {
        when {
            position == 0 -> {
                defineSimpleAndCompleteContent()
            }
            position == 1 -> {
                defineNoBurocracyContent()
            }
            position == 2 -> {
                defineVisaCoverageContent()
            }
        }
    }

    fun defineSimpleAndCompleteContent() {
        title.set(R.string.simple_and_complete)
        description.set(R.string.description_simple_and_complete)
        icon.set(R.mipmap.icon_profile)
    }

    fun defineNoBurocracyContent() {
        title.set(R.string.no_bureaucracy)
        description.set(R.string.description_no_bureaucracy)
        icon.set(R.mipmap.icon_transferir)
    }

    fun defineVisaCoverageContent() {
        title.set(R.string.visa_coverage)
        description.set(R.string.description_visa_coverage)
        icon.set(R.mipmap.icon_card)
    }

    companion object {
        @JvmStatic
        @BindingAdapter("app:srcIcon")
        fun setSrcIcon(view: ImageView, @DrawableRes drawable: Int) {
            view.setImageResource(drawable)
        }
    }

}