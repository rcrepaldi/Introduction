package com.br.introduction.presentation.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View.OnFocusChangeListener
import android.widget.EditText
import com.br.introduction.R
import java.lang.ref.WeakReference


class CustomEditText constructor(context: Context, attrs: AttributeSet) : EditText(context, attrs) {

    val maxLength = 15
    var isComplete = false
    var isError = false
    var hasFocusField = false
    var labelHint: String? = null

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.CustomEditText, 0, 0).apply {
            val type = getInt(R.styleable.CustomEditText_type, 0)
            configureType(type)
        }
        context.theme.obtainStyledAttributes(attrs, R.styleable.CustomEditText, 0, 0).apply {
            labelHint = getString(R.styleable.CustomEditText_labelHint)
            if (labelHint.isNullOrEmpty()) {
                labelHint = ""
            }
        }
        configureEditTextField()
    }

    private fun configureEditTextField() {
        onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                configureEditTextActiveOrSuccess()
            } else {
                configureEditTextInactiveOrError()
            }
        }
    }

    private fun configureEditTextActiveOrSuccess() {
        resetComponentFocused()
        addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                hasFocusField = true
                isError = false
                if (!editable.isNullOrEmpty() && editable!!.length == maxLength) {
                    setBackgroundResource(R.drawable.edittext_background_success)
                    isComplete = true
                } else {
                    setBackgroundResource(R.drawable.edittext_background)
                    setTextColor(ContextCompat.getColor(context, R.color.colorMainText))
                    isComplete = false
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })

    }

    private fun resetComponentFocused() {
        hasFocusField = true
        isError = false
        setTextColor(ContextCompat.getColor(context, R.color.colorMainText))
        val background = if (text.length == maxLength) {
            R.drawable.edittext_background_success
        } else {
            R.drawable.edittext_background
        }
        setBackgroundResource(background)
    }

    private fun configureEditTextInactiveOrError() {
        hasFocusField = false
        isError = if (text.length in 1..(maxLength - 1)) {
            setBackgroundResource(R.drawable.edittext_background_error)
            setTextColor(ContextCompat.getColor(context, R.color.colorNegativeMainActive))
            true
        } else {
            false
        }
    }

    private fun configureType(type: Int) {
        when (type) {
            1 -> addTextChangedListener(MaskEditUtil(WeakReference(this)))
            2 -> {
                // TODO
            }
        }
    }

    override fun draw(canvas: Canvas?) {
        createHintText(canvas)
        super.draw(canvas)
    }

    private fun createHintText(canvas: Canvas?) {
        val plain: Typeface = Typeface.createFromAsset(context.assets, context.getString(R.string.fontLight))
        val paint = Paint()
        paint.typeface = plain
        paint.color = getColor()
        val spTextSize = 16f
        val textSize = spTextSize * resources.displayMetrics.scaledDensity
        paint.textSize = textSize
        paddingEditText()
        canvas!!.drawText(labelHint, 0F, textSize, paint)
    }

    fun getColor(): Int {
        val color = if (isComplete) {
            R.color.colorAccentMainActive
        } else if (hasFocusField) {
            R.color.colorAccentMainComplementary
        } else if (isError && !hasFocusField) {
            R.color.colorNegativeMainActive
        } else {
            R.color.colorMainText
        }
        return ContextCompat.getColor(context, color)
    }

    private fun paddingEditText() {
        val space = 24f
        val spaceSize = space * resources.displayMetrics.scaledDensity
        setPadding(0, spaceSize.toInt(), 0, 0)
    }
}