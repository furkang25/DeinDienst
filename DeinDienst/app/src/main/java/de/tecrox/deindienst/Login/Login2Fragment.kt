package de.tecrox.deindienst.Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import de.tecrox.deindienst.R
//import com.google.firebase.auth.FirebaseAuth

class Login2Fragment : Fragment() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    //private lateinit var mAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate das Layout für dieses Fragment
        val view = inflater.inflate(R.layout.fragment_login2, container, false)
        val view2 = inflater.inflate(R.layout.fragment_register, container, false)

        emailEditText = view.findViewById(R.id.email)
        passwordEditText = view.findViewById(R.id.password)
        loginButton = view.findViewById(R.id.loginButton)
        registerButton = view2.findViewById(R.id.registerButton)

        // Finde den ImageButton und setze einen OnClickListener
        val backButton: ImageButton = view.findViewById(R.id.back_button_login2)
        backButton.setOnClickListener {
            // Gehe zum vorherigen Fragment zurück
            parentFragmentManager.popBackStack()
        }

        return view
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