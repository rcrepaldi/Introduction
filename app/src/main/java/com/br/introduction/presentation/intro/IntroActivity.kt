package com.br.introduction.presentation.intro

import android.os.Bundle
import com.br.introduction.R
import com.br.introduction.presentation.BaseActivity


class IntroActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
    }
}
