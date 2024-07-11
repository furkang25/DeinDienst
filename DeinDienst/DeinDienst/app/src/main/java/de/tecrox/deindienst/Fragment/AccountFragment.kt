package de.tecrox.deindienst.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import de.tecrox.deindienst.Account.AnzeigenFragment
import de.tecrox.deindienst.Account.DienstFragment
import de.tecrox.deindienst.Account.FavoritFragment
import de.tecrox.deindienst.R
import de.tecrox.deindienst.SettingsActivity

class AccountFragment : Fragment() {

    // Diese Methode wird aufgerufen, wenn das Fragment die Ansicht erstellt
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Initiales Dienst Seite direkt laden
        loadFragment(DienstFragment())

        // Die Layout-Datei für dieses Fragment aufblähen (inflate)
        val view = inflater.inflate(R.layout.fragment_account, container, false)

        // Das BottomNavigationView-Element aus der aufgeblasenen Ansicht finden
        val bottomNavigationView: BottomNavigationView = view.findViewById(R.id.bottom_navigation)

        // Einen Listener setzen, der auf die Auswahl von Navigationselementen reagiert
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                // Wenn das Element mit der ID 'navigation_service' ausgewählt wird
                R.id.navigation_service -> {
                    // Fragment wechseln und 'DienstFragment' laden
                    loadFragment(DienstFragment())
                    true
                }
                // Wenn das Element mit der ID 'navigation_display' ausgewählt wird
                R.id.navigation_display -> {
                    // Fragment wechseln und 'AnzeigenFragment' laden
                    loadFragment(AnzeigenFragment())
                    true
                }
                // Wenn das Element mit der ID 'navigation_favorite' ausgewählt wird
                R.id.navigation_favorite -> {
                    // Fragment wechseln und 'FavoritFragment' laden
                    loadFragment(FavoritFragment())
                    true
                }
                // Standardfall: Keine Aktion
                else -> {
                    false
                }
            }
        }

        val settingsButton: ImageButton = view.findViewById(R.id.settingsButton)
        settingsButton.setOnClickListener {
            startActivity(Intent(activity, SettingsActivity::class.java))
        }

        // Die aufgeblasene Ansicht zurückgeben
        return view
    }


    private fun loadSettingsFragment() {
        // Transaktion starten, AccountFragment zum Back Stack hinzufügen und SettingsFragment laden
        parentFragmentManager.beginTransaction()
            .replace(R.id.containerSettings, SettingsFragment())
            .addToBackStack(null) // Zum Back Stack hinzufügen
            .commit()
    }

    // Methode zum Laden eines neuen Fragments
    private fun loadFragment(fragment: Fragment) {
        // Transaktion starten und das alte Fragment durch das neue ersetzen
        childFragmentManager.beginTransaction()
            .replace(R.id.containerSettings, fragment)
            .commit()
    }
}
