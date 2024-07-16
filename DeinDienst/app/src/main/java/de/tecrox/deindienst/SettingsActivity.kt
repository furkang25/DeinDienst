package de.tecrox.deindienst

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import de.tecrox.deindienst.Fragment.SettingsFragment
import android.widget.Button

class SettingsActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private val TAG = "SettingsActivity"

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

        // Fragment initialisieren
        supportFragmentManager.beginTransaction()
            .replace(R.id.settings_container, SettingsFragment())
            .commit()

        // Abmelden-Button referenzieren und Klick-Listener setzen
        val logoutButton: Button = findViewById(R.id.abmelden_Button)
        logoutButton.setOnClickListener {
            Log.d(TAG, "Logout button clicked")
            mAuth.signOut()
            Log.d(TAG, "User signed out")
            if (mAuth.currentUser == null) {
                Log.d(TAG, "User is null, sign out successful")
            } else {
                Log.d(TAG, "User is not null, sign out failed")
            }
            // Nach dem Abmelden zur Login-Aktivität weiterleiten
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}
