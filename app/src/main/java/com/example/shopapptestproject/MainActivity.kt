package com.example.shopapptestproject

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.shopapptestproject.screens.ChatFragment
import com.example.shopapptestproject.databinding.ActivityMainBinding
import com.example.shopapptestproject.screens.PaymentFragment
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.place_holder, ChatFragment.newInstance() ).commit()

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_english -> setLocale("en")
            R.id.action_russian -> setLocale("ru")
            R.id.action_kyrgyz -> setLocale("kg")
        }
        return super.onOptionsItemSelected(item)
    }
    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        // Save the selected language to shared preferences
        val sharedPref = getSharedPreferences("Settings", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("My_Lang", languageCode)
        editor.apply()

        // Restart activity to apply changes
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
//    override fun attachBaseContext(newBase: Context) {
//        val sharedPref = newBase.getSharedPreferences("Settings", Context.MODE_PRIVATE)
//        val language = sharedPref.getString("My_Lang", "en")
//        val context = ContextWrapper.wrap(newBase, Locale(language))
//        super.attachBaseContext(context)
//    }
}