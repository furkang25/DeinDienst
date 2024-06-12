package de.tecrox.deindienst.Account

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        // Return the number of tabs
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        // Return the corresponding Fragment for each tab
        return when (position) {
            0 -> DienstFragment()
            1 -> AnzeigenFragment()
            2 -> FavoritFragment()
            else -> throw IllegalArgumentException("Invalid tab position")
        }
    }
}

