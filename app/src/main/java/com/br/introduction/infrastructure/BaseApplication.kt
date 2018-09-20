package com.br.introduction.infrastructure

import android.app.Application
import com.crashlytics.android.answers.Answers
import io.fabric.sdk.android.Fabric

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Answers())
    }
}