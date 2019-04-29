package com.chahinem.pageindicator

import androidx.viewpager2.widget.ViewPager2

internal class PageChangeCallback(private val indicator: PageIndicator) : ViewPager2.OnPageChangeCallback() {

  private var selectedPage = 0

  override fun onPageScrollStateChanged(state: Int) {}

  override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

  override fun onPageSelected(position: Int) {
    if (position != selectedPage) {
      when {
        this.selectedPage < position -> indicator.swipeNext()
        else -> indicator.swipePrevious()
      }
    }
    selectedPage = position
  }
}