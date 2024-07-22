package de.tecrox.deindienst.Login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import de.tecrox.deindienst.Fragment.HomeFragment
import de.tecrox.deindienst.MainActivity
import de.tecrox.deindienst.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // Finde den ImageButton und setze einen OnClickListener
        val closeButton: ImageButton = view.findViewById(R.id.closeButtonLogin)
        closeButton.setOnClickListener {
            // Starte die MainActivity
            startActivity(Intent(activity, MainActivity::class.java))
            activity?.finish()
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


        // BottomNavigationView im Activity-Kontext finden und einblenden
        val bottomNavigationBarView = activity?.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationBarView?.visibility = View.GONE

        return view
    }
}