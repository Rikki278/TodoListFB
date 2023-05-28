package com.example.todolistfb

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.navigation.NavController
import com.example.todolistfb.databinding.ActivitySettingBinding


class SettingActivity : AppCompatActivity() {


    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val switch = findViewById<SwitchCompat>(R.id.switch1)
        val picture = findViewById<ImageView>(R.id.imageView)
        val textChange = findViewById<TextView>(R.id.textChange)

        val sharedPreferences = getSharedPreferences("Mode", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val nightMode = sharedPreferences.getBoolean("night", false)


        binding.nextBtn.setOnClickListener {
            onBackPressed()
        }

        if (nightMode) {
            switch.isChecked = true
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            picture.setImageResource(R.drawable.vergil_smile)
            textChange.text = "Motivated"

        }


        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (!isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor.putBoolean("night", false)
                editor.apply()
                picture.setImageResource(R.drawable.vergil_no_smile)
                textChange.text = "Pathetic"

            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                editor.putBoolean("night", true)
                editor.apply()
                picture.setImageResource(R.drawable.vergil_smile)
                textChange.text = "Motivated"

            }

        }
    }

}