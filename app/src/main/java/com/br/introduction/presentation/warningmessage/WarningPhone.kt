package com.br.introduction.presentation.warningmessage

import android.content.Context
import android.view.LayoutInflater
import com.br.introduction.R
import kotlinx.android.synthetic.main.warning_base.view.*
import kotlinx.android.synthetic.main.warning_phone.view.*

class WarningPhone constructor(val context: Context) : BaseWarning(context), OnWarningPhoneListener {

    init {
        val viewSample = LayoutInflater.from(context).inflate(R.layout.warning_phone, rootView, false)
        view.containerBottom.addView(viewSample)

        view.buttonCancel.setOnClickListener {
            throw Exception("Missing implements the onPositiveButton() event method")
        }
        view.buttonSend.setOnClickListener {
            throw Exception("Missing implements the onNegativeButton event method")
        }
        view.phone.contentDescription = view.phone.text
    }

    override fun onPositiveButton(callback: () -> Unit) {
        view.buttonSend.setOnClickListener {
            callback()
        }
    }

    override fun onNegativeButton(callback: () -> Unit) {
        view.buttonCancel.setOnClickListener {
            callback()
        }
    }
}