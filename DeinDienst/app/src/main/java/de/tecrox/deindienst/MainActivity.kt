package de.tecrox.deindienst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import de.tecrox.deindienst.Fragment.*

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Löschen von Action Bar
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Navigation zu denn andere Seiten
        loadFragment(HomeFragment())
        bottomNav = findViewById(R.id.bottom_navigation) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.menu_search -> {
                    loadFragment(SearchFragment())
                    true
                }
                R.id.menu_create -> {
                    loadFragment(CreateFragment())
                    true
                }
                R.id.menu_messages -> {
                    loadFragment(MessagesFragment())
                    true
                }
                R.id.menu_account -> {
                    loadFragment(AccountFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}
