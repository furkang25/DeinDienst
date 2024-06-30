package de.tecrox.deindienst.Fragment

import de.tecrox.deindienst.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class CreateFragment : Fragment() {

    // Diese Methode wird aufgerufen, um die Benutzeroberfläche des Fragments zu erstellen
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Layout des Fragments aufblasen (in die View umwandeln)
        val view = inflater.inflate(R.layout.fragment_create, container, false)



        // BottomNavigationView im Activity-Kontext finden und ausblenden
        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView?.visibility = View.GONE

        // ImageButton für das Zurückgehen initialisieren
        val buttonBackCreate: ImageButton = view.findViewById(R.id.buttonBackCreate)
        buttonBackCreate.setOnClickListener {
            // Zurück zum vorherigen Fragment
            activity?.supportFragmentManager?.popBackStack()
        }

        // Die erstellte View des Fragments zurückgeben, die angezeigt werden soll
        return view
    }

    // Diese Methode wird aufgerufen, wenn das Fragment zerstört wird
    override fun onDestroyView() {
        super.onDestroyView()

        // BottomNavigationView wieder einblenden, wenn das Fragment zerstört wird
        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView?.visibility = View.VISIBLE
    }
}
