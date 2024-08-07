package de.tecrox.deindienst.Settings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import de.tecrox.deindienst.R

class NotificationsFragment : Fragment() {

    // Diese Methode wird aufgerufen, um die Benutzeroberfläche des Fragments zu erstellen
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Layout des Fragments aufblasen (in die View umwandeln)
        val view = inflater.inflate(R.layout.fragment_settings_notifications, container, false)

        // ImageButton für den Zurück-Button initialisieren
        val backButton: ImageButton = view.findViewById(R.id.buttonBackSettings)
        backButton.setOnClickListener {
            // Log-Ausgabe hinzufügen, um anzuzeigen, dass der Zurück-Button geklickt wurde
            Log.d("SettingsFragment", "Back button clicked")

            // Zurück zur vorherigen Ansicht der Aktivität gehen
            requireActivity().onBackPressed()
        }


        // Die erstellte View des Fragments zurückgeben, die angezeigt werden soll
        return view
    }
}