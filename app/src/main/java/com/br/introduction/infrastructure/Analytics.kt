package com.br.introduction.infrastructure

import com.crashlytics.android.answers.Answers
import com.crashlytics.android.answers.CustomEvent

class Analytics {

    companion object {
        fun logAnalyticsScreen(contextName: String) {

            Answers.getInstance().logCustom(CustomEvent(Constants.AnalyticsContextName.SCREEN_VIEWS)
                    .putCustomAttribute(Constants.AnalyticsEventKeys.SCREENS, contextName))

            Answers.getInstance().logCustom(CustomEvent(contextName)
                    .putCustomAttribute(Constants.AnalyticsEventKeys.SCREENS, Constants.AnalyticsParams.COUNT))
        }

        fun logAnalyticsEventIntro(key: String, param: String) {

            Answers.getInstance().logCustom(CustomEvent(Constants.AnalyticsContextName.INTRO)
                    .putCustomAttribute(key, param))

        }
    }
}