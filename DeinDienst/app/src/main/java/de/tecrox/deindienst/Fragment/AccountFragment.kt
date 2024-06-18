package de.tecrox.deindienst.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import de.tecrox.deindienst.Account.ViewPagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import de.tecrox.deindienst.Account.SettingsFragment
import de.tecrox.deindienst.R

class AccountFragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    private lateinit var settingsButton: ImageButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Das Layout für dieses Fragment aufblasen
        val view = inflater.inflate(R.layout.fragment_account, container, false)

        // Initialisiere die Ansichten
        settingsButton = view.findViewById(R.id.settingsButton)

        // Setze einen Klicklistener für den Einstellungsbutton
        settingsButton.setOnClickListener {
            val fragment = SettingsFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        // Initialize views
        tabLayout = view.findViewById(R.id.tabLayout)
        viewPager = view.findViewById(R.id.viewPager)

        // Set up ViewPager2
        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        // Connect TabLayout with ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Dienst"
                1 -> tab.text = "Anzeigen"
                2 -> tab.text = "Favoriten"
                else -> tab.text = ""
            }
        }.attach()

        return view
    }
}


        /*

        settingsButton.setOnClickListener {
            findNavController().navigate(R.id.action_accountFragment_to_settingsFragment)
        }

        // Initialisiere die Ansichten
        settingsButton = view.findViewById(R.id.settingsButton)

        // Setze einen Klicklistener für den Einstellungsbutton
        settingsButton.setOnClickListener {
            // Erstelle eine neue Instanz von SettingsFragment
            val settingsFragment = SettingsFragment()

            val fragment = SettingsFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }


        val settingsButton: ImageButton = view.findViewById(R.id.settingsButton)
        settingsButton.setOnClickListener {
            val fragment = SettingsFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_container, fragment)?.commit()
        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up settings button to navigate to SettingsActivity
        val settingsButton = view.findViewById<ImageButton>(R.id.settingsButton)
        settingsButton.setOnClickListener {
            navigateToSettings()
        }
    }

    private fun navigateToSettings() {
        val action: NavDirections = AccountFragmentDirections.actionAccountFragmentToSettingsFragment()
        navController.navigate(action)
    }

     */