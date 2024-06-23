package de.tecrox.deindienst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import de.tecrox.deindienst.Fragment.*

class MainActivity : AppCompatActivity() {

    // Spätinitialisierte Variable für das BottomNavigationView
    lateinit var bottomNav: BottomNavigationView

    // Diese Methode wird aufgerufen, wenn die Aktivität erstellt wird
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Aktion Bar löschen und die Aktivität im Vollbildmodus anzeigen
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // Initiales Fragment laden
        loadFragment(HomeFragment())

        // BottomNavigationView-Element aus der Layout-Datei finden
        bottomNav = findViewById(R.id.bottom_navigation) as BottomNavigationView

        // Listener setzen, der auf die Auswahl von Navigationselementen reagiert
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                // Wenn das Element mit der ID 'menu_home' ausgewählt wird
                R.id.menu_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                // Wenn das Element mit der ID 'menu_search' ausgewählt wird
                R.id.menu_search -> {
                    loadFragment(SearchFragment())
                    true
                }
                // Wenn das Element mit der ID 'menu_create' ausgewählt wird
                R.id.menu_create -> {
                    loadFragment(CreateFragment())
                    true
                }
                // Wenn das Element mit der ID 'menu_messages' ausgewählt wird
                R.id.menu_messages -> {
                    loadFragment(MessagesFragment())
                    true
                }
                // Wenn das Element mit der ID 'menu_account' ausgewählt wird
                R.id.menu_account -> {
                    loadFragment(AccountFragment())
                    true
                }
                // Standardfall: Keine Aktion
                else -> {
                    false
                }
            }
        }
    }

    // Methode zum Laden eines neuen Fragments
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        // Das alte Fragment durch das neue ersetzen
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}
