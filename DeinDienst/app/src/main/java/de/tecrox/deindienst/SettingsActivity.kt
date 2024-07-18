package de.tecrox.deindienst

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import de.tecrox.deindienst.Login.LoginFragment

class SettingsActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_settings)

        // Firebase initialisieren
        mAuth = FirebaseAuth.getInstance()

        // Aktion Bar löschen und die Aktivität im Vollbildmodus anzeigen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // ImageButton für den Zurück-Button initialisieren
        val backButton: ImageButton = findViewById(R.id.buttonBackSettings)
        backButton.setOnClickListener {
            Log.d("SettingsActivity", "Back button clicked")
            onBackPressed()  // Zurück zur vorherigen Ansicht gehen
        }

        // Teste Abmelden
        val logoutButton: Button = findViewById(R.id.logoutButton)
        logoutButton.setOnClickListener {
            logoutUser()
        }
    }

    private fun logoutUser() {
        mAuth.signOut()
        Log.d("SettingsActivity", "User logged out")
        // Lade Login-Fragment nach dem Abmelden
        loadFragment(LoginFragment())
    }

    // Methode zum Laden eines neuen Fragments
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        // Das aktuelle Fragment im Hauptcontainer durch das neue ersetzen
        transaction.replace(R.id.settings_container, fragment)
        transaction.addToBackStack(null)  // Zurückkehren zu diesem Fragment erlauben
        transaction.commit()  // Transaktion abschließen und das Fragment anzeigen
    }
}
