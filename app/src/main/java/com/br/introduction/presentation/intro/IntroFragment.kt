package com.br.introduction.presentation.intro

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.br.introduction.R
import com.br.introduction.databinding.FragmentIntroBinding
import com.br.introduction.infrastructure.Analytics
import com.br.introduction.infrastructure.Constants
import com.br.introduction.presentation.customviews.Pagination
import com.br.introduction.presentation.intro.carousel.CarouselFragment


/**
 * A placeholder fragment containing a simple view.
 */
class IntroFragment : Fragment() {

    private val COUNT_VIEW_PAGER = 3
    lateinit var viewModel: IntroViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        viewModel = IntroViewHolder().viewModel()
        val binding: FragmentIntroBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_intro, container, false)
        binding.viewModel = viewModel
        binding.executePendingBindings()
        addViewPager(binding.root)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Analytics.logAnalyticsScreen(Constants.AnalyticsContextName.INTRO)
    }

    fun addViewPager(view: View) {
        val viewPager: ViewPager = view.findViewById(R.id.viewPager)
        val pagination: Pagination = view.findViewById(R.id.pagination)
        val pageAdapter = CarouselPagerAdapter(childFragmentManager)
        viewPager.adapter = pageAdapter
        viewModel.addViewPagerListener(viewPager, pagination)
    }

    private inner class CarouselPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {

            val fragment = CarouselFragment()
            val args = Bundle()
            args.putInt(fragment.POSITION_PARAM, position)
            fragment.arguments = args

            return fragment
        }

        override fun getCount(): Int {
            return COUNT_VIEW_PAGER
        }
    }

    internal class IntroViewHolder {
        fun viewModel() = IntroViewModel()
    }
}
