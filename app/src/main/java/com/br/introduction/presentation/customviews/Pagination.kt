package com.br.introduction.presentation.customviews

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.br.introduction.R


class Pagination constructor(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    var count: Int = 1
    var circleSize: Int = 1
    var space: Int = 0

    init {

        context.theme.obtainStyledAttributes(attrs, R.styleable.Pagination, 0, 0).apply {
            count = getInt(R.styleable.Pagination_count, 1)
        }
        context.theme.obtainStyledAttributes(attrs, R.styleable.Pagination, 0, 0).apply {
            circleSize = getLayoutDimension(R.styleable.Pagination_circleSize, 1)
        }
        context.theme.obtainStyledAttributes(attrs, R.styleable.Pagination, 0, 0).apply {
            space = getLayoutDimension(R.styleable.Pagination_space, 0)
        }
        setPagePosition(0)
    }

    fun setPagePosition(position: Int) {
        removeAllViews()
        var i = 0
        while (i < count) {
            if (i == position)
                createViewPage(R.color.colorAccentMainActive)
            else
                createViewPage(android.R.color.black)
            i++
        }
    }

    fun createViewPage(color: Int) {
        val itemPage = View(context)
        itemPage.setBackgroundColor(Color.RED)
        itemPage.layoutParams = LinearLayout.LayoutParams(circleSize, circleSize)
        itemPage.background = generateShapeCircleDrawable(color)
        addView(itemPage, addMargin(itemPage.layoutParams as LayoutParams))
    }

    fun addMargin(layoutParams: ViewGroup.MarginLayoutParams): ViewGroup.MarginLayoutParams {
        val paddin = if (space != 0) space / 2 else 0
        layoutParams.setMargins(paddin, 0, paddin, 0)
        return layoutParams
    }

    fun generateShapeCircleDrawable(color: Int): ShapeDrawable {
        val badge = ShapeDrawable(OvalShape())
        badge.intrinsicWidth = 200
        badge.intrinsicHeight = 200
        badge.paint.color = ContextCompat.getColor(context, color)
        return badge
    }
}