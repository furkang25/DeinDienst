package de.tecrox.deindienst.Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import de.tecrox.deindienst.MainActivity
import de.tecrox.deindienst.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // BottomNavigationView ausblenden
        (activity as? MainActivity)?.hideBottomNav()

        // Finde den ImageButton und setze einen OnClickListener
        val closeButton: ImageButton = view.findViewById(R.id.closeButtonLogin)
        closeButton.setOnClickListener {
            // Gehe zum vorherigen Fragment zurück
            parentFragmentManager.popBackStack()
        }

        val registerButton: Button = view.findViewById(R.id.registerLink)
        registerButton.setOnClickListener {
            val registerFragment = RegisterFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_containerLogin, registerFragment)
                .addToBackStack(null)
                .commit()
        }

        val loginButton: Button = view.findViewById(R.id.loginLink)
        loginButton.setOnClickListener {
            val login2Fragment = Login2Fragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_containerLogin, login2Fragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // BottomNavigationView wieder einblenden, wenn das Fragment zerstört wird
        (activity as? MainActivity)?.showBottomNav()
    }
}