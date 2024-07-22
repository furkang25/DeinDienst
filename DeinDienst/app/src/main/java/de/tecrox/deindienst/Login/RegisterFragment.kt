package de.tecrox.deindienst.Login

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
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import de.tecrox.deindienst.Fragment.AccountFragment
import de.tecrox.deindienst.R

class RegisterFragment : Fragment() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var database: DatabaseReference

    private lateinit var emailEditData: EditText
    private lateinit var passwordEditData: EditText
    private lateinit var nameEditData: EditText
    private lateinit var addressEditData: EditText
    private lateinit var postalcodeEditData: EditText
    private lateinit var telephoneEditData: EditText

    private lateinit var registerButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate das Layout für dieses Fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        // Initialisiere Firebase Auth und Database
        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().reference

        // Initialisiere die EditText Felder
        emailEditData = view.findViewById(R.id.emailData)
        passwordEditData = view.findViewById(R.id.passwordData)
        nameEditData = view.findViewById(R.id.nameData)
        addressEditData = view.findViewById(R.id.addressData)
        postalcodeEditData = view.findViewById(R.id.postalcodeData)
        telephoneEditData = view.findViewById(R.id.telephoneData)

        // Initialisiere die Buttons
        registerButton = view.findViewById(R.id.registerButton)

        // Finde den ImageButton und setze einen OnClickListener
        val backButton: ImageButton = view.findViewById(R.id.back_button_register)
        backButton.setOnClickListener {
            // Gehe zum vorherigen Fragment zurück
            parentFragmentManager.popBackStack()
        }

        // Setze einen OnClickListener für den Registrierungsbutton
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
        val postalcode = postalcodeEditData.text.toString().trim()
        val telephone = telephoneEditData.text.toString().trim()

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

        mAuth.fetchSignInMethodsForEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val signInMethods = task.result?.signInMethods ?: emptyList<String>()
                    if (signInMethods.isNotEmpty()) {
                        // E-Mail-Adresse wird bereits verwendet
                        Toast.makeText(activity, "Diese E-Mail-Adresse wird bereits verwendet", Toast.LENGTH_SHORT).show()
                    } else {
                        // E-Mail-Adresse ist verfügbar, registriere den Benutzer
                        mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(requireActivity()) { createTask ->
                                if (createTask.isSuccessful) {
                                    val user: FirebaseUser? = mAuth.currentUser
                                    val userId = user?.uid

                                    if (userId != null) {
                                        val userMap = hashMapOf(
                                            "name" to name,
                                            "address" to address,
                                            "postalcode" to postalcode,
                                            "telephone" to telephone
                                        )

                                        database.child("users").child(userId).setValue(userMap)
                                            .addOnCompleteListener { dbTask ->
                                                if (dbTask.isSuccessful) {
                                                    Toast.makeText(activity, "Registrierung erfolgreich", Toast.LENGTH_SHORT).show()
                                                    // Nach erfolgreicher Registrierung weiterleiten
                                                    loadAccountFragment()
                                                } else {
                                                    Toast.makeText(activity, "Registrierung fehlgeschlagen. Benutzerinformationen konnten nicht gespeichert werden.", Toast.LENGTH_SHORT).show()
                                                }
                                            }
                                    }
                                } else {
                                    val exception = createTask.exception
                                    when {
                                        exception is FirebaseAuthUserCollisionException -> {
                                            Toast.makeText(activity, "Diese E-Mail-Adresse wird bereits verwendet", Toast.LENGTH_SHORT).show()
                                        }
                                        else -> {
                                            Toast.makeText(activity, "Registrierung fehlgeschlagen: ${exception?.message}", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                }
                            }
                    }
                } else {
                    Toast.makeText(activity, "Fehler bei der Überprüfung der E-Mail-Adresse: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun loadAccountFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_account_container, AccountFragment())
            .addToBackStack(null)
            .commit()
    }
}
