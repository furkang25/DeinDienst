package de.tecrox.deindienst.Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
            // Navigation zum Login2Fragment ohne NavController
            val registerFragment = RegisterFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_containerLogin, registerFragment)
                .addToBackStack(null)
                .commit()
        }

        val loginButton: Button = view.findViewById(R.id.loginLink)
        loginButton.setOnClickListener {
            // Navigation zum Login2Fragment ohne NavController
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


/*

class LoginFragment : Fragment() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login2, container, false)
        val view2 = inflater.inflate(R.layout.fragment_register, container, false)

        emailEditText = view.findViewById(R.id.email)
        passwordEditText = view.findViewById(R.id.password)
        loginButton = view.findViewById(R.id.loginButton)
        registerButton = view2.findViewById(R.id.registerButton)

        mAuth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener {
            loginUser()
        }

        registerButton.setOnClickListener {
            registerUser()
        }

        return view
    }

    private fun loginUser() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(activity, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    val user: FirebaseUser? = mAuth.currentUser
                    Toast.makeText(activity, "Login successful", Toast.LENGTH_SHORT).show()
                    // Weiterleitung zur nächsten Activity
                } else {
                    Toast.makeText(activity, "Authentication failed.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun registerUser() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(activity, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    val user: FirebaseUser? = mAuth.currentUser
                    Toast.makeText(activity, "Registration successful", Toast.LENGTH_SHORT).show()
                    // Weiterleitung zur nächsten Activity
                } else {
                    Toast.makeText(activity, "Registration failed.", Toast.LENGTH_SHORT).show()
                }
            }
    }
}


 */