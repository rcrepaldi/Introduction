package com.br.introduction.presentation.intro

import android.support.v4.view.ViewPager
import com.br.introduction.BuildConfig
import com.br.introduction.presentation.customviews.Pagination
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = [27])
class IntroViewModelTest {

    lateinit var introViewModel: IntroViewModel
    lateinit var introViewModelSpy: IntroViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        introViewModel = IntroViewModel()
        introViewModelSpy = Mockito.spy(introViewModel)
    }

    @After
    fun tearDown() {
        Mockito.verifyNoMoreInteractions(introViewModelSpy)
    }

    @Test
    fun testAddViewPagerListener() {

        // Arrage
        val viewPager = Mockito.mock(ViewPager::class.java)
        val pagination = Mockito.mock(Pagination::class.java)

        // Act
        introViewModelSpy.addViewPagerListener(viewPager, pagination)

        // Assert
        Mockito.verify(introViewModelSpy).addViewPagerListener(viewPager, pagination)
    }


    @Test
    fun testAppendString() {

        // Arrage
        val tag = "tag"
        val page = 0
        val expected = "$tag $page"

        // Act
        val result = introViewModelSpy.appendString(tag, page)

        // Assert
        Mockito.verify(introViewModelSpy).appendString(tag, page)
        assertEquals(expected, result)
    }
}