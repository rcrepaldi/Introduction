package com.br.introduction.presentation.intro

import android.databinding.BaseObservable
import android.databinding.ObservableField
import android.support.v4.view.ViewPager
import android.view.View
import com.br.introduction.R
import com.br.introduction.infrastructure.Analytics
import com.br.introduction.infrastructure.Constants
import com.br.introduction.presentation.customviews.Pagination
import com.br.introduction.presentation.warningmessage.WarningDefault


class IntroViewModel : BaseObservable() {

    var pagePosition: ObservableField<Int> = ObservableField()

    fun onButtonAccessAccountClick(view: View) {
        val carousel = appendString(Constants.AnalyticsParams.CAROUSEL, pagePosition.get())
        Analytics.logAnalyticsEventIntro(Constants.AnalyticsEventKeys.ACCESS_ACCOUNT, carousel)

        val message = WarningDefault(view.context)
        message.configure(R.mipmap.icon_token,
                view.context.getString(R.string.code_sending),
                view.context.getString(R.string.description_code_sending))

        message.contentDescriptionWindows(view.context.getString(R.string.warning_message))
        message.show()

        message.onPositiveButton {
            message.dismiss()
        }
        message.onNegativeButton {
            message.dismiss()
        }
    }

    fun onButtonCreateAccountClick(view: View) {
        val carousel = appendString(Constants.AnalyticsParams.CAROUSEL, pagePosition.get())
        Analytics.logAnalyticsEventIntro(Constants.AnalyticsEventKeys.CREATE_ACCOUNT, carousel)
    }

    fun addViewPagerListener(viewPager: ViewPager, pagination: Pagination) {
        pagePosition.set(0)
        viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                pagePosition.set(position)
                pagination.setPagePosition(position)
            }
        })
    }

    fun appendString(tag: String, page: Int?): String {
        return "$tag $page"
    }
}