package de.tecrox.deindienst.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import de.tecrox.deindienst.R

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("SettingsFragment", "Fragment created") // Log-Ausgabe hinzufügen
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        val backButton: ImageButton = view.findViewById(R.id.buttonBackSettings)
        backButton.setOnClickListener {
            Log.d("SettingsFragment", "Back button clicked") // Log-Ausgabe hinzufügen
            requireActivity().onBackPressed() // Zurück zur vorherigen Ansicht
        }

        return view
    }
}

