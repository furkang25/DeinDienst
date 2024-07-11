package de.tecrox.deindienst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import de.tecrox.deindienst.Fragment.*
import de.tecrox.deindienst.Login.LoginFragment

class MainActivity : AppCompatActivity() {

    // Spätinitialisierte Variable für das BottomNavigationView
    lateinit var bottomNav: BottomNavigationView

    // Diese Methode wird aufgerufen, wenn die Aktivität erstellt wird
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Firebase initialisieren
        FirebaseApp.initializeApp(this)

        // Das Layout der Aktivität setzen
        setContentView(R.layout.activity_main)

        // Action Bar entfernen und die Aktivität im Vollbildmodus anzeigen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // Initiales Fragment laden (HomeFragment wird zuerst angezeigt)
        loadFragment(HomeFragment())

        // BottomNavigationView-Element aus der Layout-Datei finden
        bottomNav = findViewById(R.id.bottom_navigation) as BottomNavigationView

        // Listener setzen, der auf die Auswahl von Navigationselementen reagiert
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                // Wenn das Element mit der ID 'menu_home' ausgewählt wird
                R.id.menu_home -> {
                    loadFragment(HomeFragment())
                    true // true zurückgeben, um die Auswahl zu bestätigen
                }
                // Wenn das Element mit der ID 'menu_search' ausgewählt wird
                R.id.menu_search -> {
                    loadFragment(SearchFragment())
                    true // true zurückgeben, um die Auswahl zu bestätigen
                }
                // Wenn das Element mit der ID 'menu_create' ausgewählt wird
                R.id.menu_create -> {
                    loadFragment(CreateFragment())
                    true // true zurückgeben, um die Auswahl zu bestätigen
                }
                // Wenn das Element mit der ID 'menu_messages' ausgewählt wird
                R.id.menu_messages -> {
                    loadFragment(MessagesFragment())
                    true // true zurückgeben, um die Auswahl zu bestätigen
                }
                // Wenn das Element mit der ID 'menu_account' ausgewählt wird
                R.id.menu_account -> {
                    if (isUserLoggedIn()) {
                        loadFragment(AccountFragment())
                    } else {
                        loadFragment(LoginFragment())
                    }
                    true // true zurückgeben, um die Auswahl zu bestätigen
                }
                // Standardfall: Keine Aktion
                else -> {
                    false // false zurückgeben, um die Auswahl abzulehnen
                }
            }
        }

    }

    // Methode zum Laden eines neuen Fragments
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        // Das aktuelle Fragment im Hauptcontainer durch das neue ersetzen
        transaction.replace(R.id.container_main, fragment)
        transaction.addToBackStack(null) // Zurückkehren zu diesem Fragment erlauben
        transaction.commit() // Transaktion abschließen und das Fragment anzeigen
    }

    // Dummy-Funktion zur Überprüfung des Anmeldestatusi
    private fun isUserLoggedIn(): Boolean {
        // Hier kannst du den tatsächlichen Anmeldestatus überprüfen
        // Zum Beispiel: return userSessionManager.isUserLoggedIn()
        return false // Dummy-Wert: Benutzer ist nicht angemeldet
    }

    fun showBottomNav() {
        bottomNav.visibility = View.VISIBLE
    }

    fun hideBottomNav() {
        bottomNav.visibility = View.GONE
    }

}
