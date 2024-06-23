package de.tecrox.deindienst.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import de.tecrox.deindienst.Account.AnzeigenFragment
import de.tecrox.deindienst.Account.DienstFragment
import de.tecrox.deindienst.Account.FavoritFragment
import de.tecrox.deindienst.R


class AccountFragment : Fragment() {

    // Diese Methode wird aufgerufen, wenn das Fragment die Ansicht erstellt
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
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

        // Die aufgeblasene Ansicht zurückgeben
        return view
    }

    // Methode zum Laden eines neuen Fragments
    private fun loadFragment(fragment: Fragment) {
        // Transaktion starten und das alte Fragment durch das neue ersetzen
        childFragmentManager.beginTransaction()
            .replace(R.id.container2, fragment)
            .commit()
    }
}
