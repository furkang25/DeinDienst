package de.tecrox.deindienst


import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import de.tecrox.deindienst.Fragment.SettingsFragment

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_settings)


        // Aktion Bar löschen und die Aktivität im Vollbildmodus anzeigen
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        supportFragmentManager.beginTransaction()
            .replace(R.id.settings_container, SettingsFragment())
            .commit()
    }
}
