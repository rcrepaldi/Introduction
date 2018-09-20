package com.br.introduction.presentation.warningmessage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.br.introduction.R
import kotlinx.android.synthetic.main.warning_base.view.*
import kotlinx.android.synthetic.main.warning_sample.view.*

class WarningSample constructor(val context: Context) : BaseWarning(context) {

    private val clickUnderstoodListener = View.OnClickListener {
        super.dismiss()
    }

    init {
        configure(R.mipmap.icon_ajustes,
                context.getString(R.string.permission_required),
                context.getString(R.string.description_permission_required))

        val viewSample = LayoutInflater.from(context).inflate(R.layout.warning_sample, rootView, false)
        viewSample.buttonUnderstood.setOnClickListener(clickUnderstoodListener)
        view.containerBottom.addView(viewSample)
    }
}