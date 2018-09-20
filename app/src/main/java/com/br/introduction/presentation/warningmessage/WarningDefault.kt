package com.br.introduction.presentation.warningmessage

import android.content.Context
import android.view.LayoutInflater
import com.br.introduction.R
import kotlinx.android.synthetic.main.warning_base.view.*
import kotlinx.android.synthetic.main.warning_default.view.*


class WarningDefault constructor(val context: Context) : BaseWarning(context), OnWarningDefaultListener {

    init {
        val viewSample = LayoutInflater.from(context).inflate(R.layout.warning_default, rootView, false)
        view.containerBottom.addView(viewSample)

        view.buttonAllow.setOnClickListener {
            throw Exception("Missing implements the onPositiveButton() event method")
        }
        view.buttonDeny.setOnClickListener {
            throw Exception("Missing implements the onNegativeButton event method")
        }
    }

    override fun onPositiveButton(callback: () -> Unit) {
        view.buttonAllow.setOnClickListener {
            callback()
        }
    }

    override fun onNegativeButton(callback: () -> Unit) {
        view.buttonDeny.setOnClickListener {
            callback()
        }
    }
}