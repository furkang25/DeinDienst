package de.tecrox.deindienst.Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import de.tecrox.deindienst.R

class Login2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate das Layout für dieses Fragment
        val view = inflater.inflate(R.layout.fragment_login2, container, false)

        // Finde den ImageButton und setze einen OnClickListener
        val backButton: ImageButton = view.findViewById(R.id.back_button_login2)
        backButton.setOnClickListener {
            // Gehe zum vorherigen Fragment zurück
            parentFragmentManager.popBackStack()
        }

        return view
    }

}