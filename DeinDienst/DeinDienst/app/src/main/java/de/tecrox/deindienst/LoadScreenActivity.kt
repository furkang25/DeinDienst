package de.tecrox.deindienst

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class LoadScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_screen)

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this@LoadScreenActivity, MainActivity::class.java)
            startActivity(intent)
        }, 1000)
    }
}