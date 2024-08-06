package de.tecrox.deindienst.Login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import de.tecrox.deindienst.Fragment.AccountFragment
import de.tecrox.deindienst.Fragment.HomeFragment
import de.tecrox.deindienst.MainActivity
import de.tecrox.deindienst.R

class Login2Fragment : Fragment() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate das Layout für dieses Fragment
        val view = inflater.inflate(R.layout.fragment_login2, container, false)

        // Initialisiere Firebase Auth
        mAuth = FirebaseAuth.getInstance()

        // UI-Elemente referenzieren
        emailEditText = view.findViewById(R.id.email)
        passwordEditText = view.findViewById(R.id.password)
        loginButton = view.findViewById(R.id.loginButton)

        // Finde den ImageButton und setze einen OnClickListener
        val backButton: ImageButton = view.findViewById(R.id.back_button_login2)
        backButton.setOnClickListener {
            loadFragment(LoginFragment())
        }

        loginButton.setOnClickListener {
            loginUser()
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
                    startMainActivity()
                } else {
                    Toast.makeText(activity, "Authentication failed.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun startMainActivity() {
        val intent = Intent(activity, MainActivity::class.java)
        // Optional: Flags setzen, um sicherzustellen, dass der Benutzer nicht zurück zur Anmeldeaktivität wechseln kann
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        requireActivity().finish() // Schließt die aktuelle Aktivität
    }

    // Methode zum Laden eines neuen Fragments
    private fun loadFragment(fragment: Fragment) {
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.container_login2, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
