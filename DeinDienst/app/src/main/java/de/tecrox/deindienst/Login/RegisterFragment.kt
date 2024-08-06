package de.tecrox.deindienst.Login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import de.tecrox.deindienst.Fragment.AccountFragment
import de.tecrox.deindienst.MainActivity
import de.tecrox.deindienst.R

class RegisterFragment : Fragment() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var database: DatabaseReference

    private lateinit var emailEditData: EditText
    private lateinit var passwordEditData: EditText
    private lateinit var nameEditData: EditText
    private lateinit var addressEditData: EditText
    private lateinit var postalCodeEditData: EditText
    private lateinit var telephoneEditData: EditText
    private lateinit var registerButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        // Firebase Auth und Database initialisieren
        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance("https://dein-dienst-eee06-default-rtdb.europe-west1.firebasedatabase.app").reference

        // Initialisiere die EditText-Felder und Buttons
        emailEditData = view.findViewById(R.id.emailData)
        passwordEditData = view.findViewById(R.id.passwordData)
        nameEditData = view.findViewById(R.id.nameData)
        addressEditData = view.findViewById(R.id.addressData)
        postalCodeEditData = view.findViewById(R.id.postalcodeData)
        telephoneEditData = view.findViewById(R.id.telephoneData)
        registerButton = view.findViewById(R.id.registerButton)

        val backButton: ImageButton = view.findViewById(R.id.back_button_register)
        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        registerButton.setOnClickListener {
            registerUser()
        }

        return view
    }

    private fun registerUser() {
        val email = emailEditData.text.toString().trim()
        val password = passwordEditData.text.toString().trim()
        val name = nameEditData.text.toString().trim()
        val address = addressEditData.text.toString().trim()
        val postalCode = postalCodeEditData.text.toString().trim().toIntOrNull()
        val telephone = telephoneEditData.text.toString().trim().toLongOrNull()

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(name)) {
            Toast.makeText(activity, "Bitte füllen Sie E-Mail, Passwort und Name aus", Toast.LENGTH_SHORT).show()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(activity, "Bitte geben Sie eine gültige E-Mail-Adresse ein", Toast.LENGTH_SHORT).show()
            return
        }

        if (password.length < 6) {
            Toast.makeText(activity, "Das Passwort muss mindestens 6 Zeichen lang sein", Toast.LENGTH_SHORT).show()
            return
        }

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { createTask ->
                if (createTask.isSuccessful) {
                    val userId = mAuth.currentUser?.uid
                    Log.d("RegisterFragment", "User created with userId: $userId")
                    val user = User(
                        name = name,
                        address = address,
                        postalCode = postalCode ?: 0, // Standardwert 0 verwenden, wenn kein Wert angegeben
                        telephone = telephone ?: 0L, // Standardwert 0 verwenden, wenn kein Wert angegeben
                        email = email
                    )
                    if (userId != null) {
                        database.child("users").child(userId).setValue(user)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Toast.makeText(activity, "Registrierung erfolgreich", Toast.LENGTH_SHORT).show()
                                    startMainActivity()
                                } else {
                                    Log.e("RegisterFragment", "Database Error: ${task.exception?.message}")
                                    Toast.makeText(activity, "Registrierung fehlgeschlagen: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                                }
                            }
                    } else {
                        Log.e("RegisterFragment", "User ID is null after successful registration")
                        Toast.makeText(activity, "Registrierung fehlgeschlagen: User ID ist null", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    val exception = createTask.exception
                    Log.e("RegisterFragment", "Auth Error: ${exception?.message}")
                    Toast.makeText(activity, "Registrierung fehlgeschlagen: ${exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    /*
    private fun redirectToAccountFragment() {
        val fragment = AccountFragment()
        parentFragmentManager.beginTransaction()
            .replace(R.id.container_register, fragment)
            .addToBackStack(null)
            .commit()
    }

     */

    private fun startMainActivity() {
        val intent = Intent(activity, MainActivity::class.java)
        // Optional: Flags setzen, um sicherzustellen, dass der Benutzer nicht zurück zur Anmeldeaktivität wechseln kann
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        requireActivity().finish() // Schließt die aktuelle Aktivität
    }

    data class User(
        val name: String,
        val address: String,
        val postalCode: Int,
        val telephone: Long,
        val email: String
    )
}
