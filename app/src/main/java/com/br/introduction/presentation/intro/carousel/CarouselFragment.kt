package com.br.introduction.presentation.intro.carousel

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.br.introduction.R
import com.br.introduction.databinding.CarouselIntroBinding

/**
 * A placeholder fragment containing a simple view.
 */
class CarouselFragment : Fragment() {

    val POSITION_PARAM = "CarouselFragment.POSITION"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val position = arguments!!.getInt(POSITION_PARAM)
        val viewModel = CarouselViewHolder(position).viewModel()
        val binding: CarouselIntroBinding = DataBindingUtil.inflate(inflater, R.layout.carousel_intro, container, false)
        binding.viewModel = viewModel
        binding.executePendingBindings()

        return binding.root
    }


    internal class CarouselViewHolder constructor(var position: Int) {
        fun viewModel() = CarouselViewModel(position)
    }
}