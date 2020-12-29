package com.example.tubeshotel_u

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    val fragments = listOf(
            Onboarding1Fragment(),
            Onboarding2Fragment(),
            Onboarding3Fragment()
    )
    override fun getItem(position: Int): Fragment {
       return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

}