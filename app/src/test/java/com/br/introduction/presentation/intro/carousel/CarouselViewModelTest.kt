package com.br.introduction.presentation.intro.carousel

import com.br.introduction.BuildConfig
import com.br.introduction.R
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = [27])
class CarouselViewModelTest {

    @Test
    fun testDefineSimpleAndCompleteContent() {
        // Arrange
        val carouselViewModel = CarouselViewModel(0)

        // Act
        carouselViewModel.defineSimpleAndCompleteContent()

        // Assert
        assertEquals(R.string.simple_and_complete, carouselViewModel.title.get())
        assertEquals(R.string.description_simple_and_complete, carouselViewModel.description.get())
        assertEquals(R.mipmap.icon_profile, carouselViewModel.icon.get())

    }

    @Test
    fun testDefineNoBurocracyContent() {
        // Arrange
        val carouselViewModel = CarouselViewModel(1)

        // Act
        carouselViewModel.defineNoBurocracyContent()

        // Assert
        assertEquals(R.string.no_bureaucracy, carouselViewModel.title.get())
        assertEquals(R.string.description_no_bureaucracy, carouselViewModel.description.get())
        assertEquals(R.mipmap.icon_transferir, carouselViewModel.icon.get())

    }

    @Test
    fun testDefineVisaCoverageContent() {
        // Arrange
        val carouselViewModel = CarouselViewModel(2)

        // Act
        carouselViewModel.defineVisaCoverageContent()

        // Assert
        assertEquals(R.string.visa_coverage, carouselViewModel.title.get())
        assertEquals(R.string.description_visa_coverage, carouselViewModel.description.get())
        assertEquals(R.mipmap.icon_card, carouselViewModel.icon.get())

    }
}