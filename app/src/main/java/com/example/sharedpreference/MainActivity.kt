package com.example.sharedpreference

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var spref = getPreferences(Context.MODE_PRIVATE)
        var color = spref.getInt("COLOR", Color.WHITE)
        binding.back.setBackgroundColor(color)

        fun saveColor(color:Int){
            var editor=spref.edit()
            editor.putInt("COLOR",color)
            editor.apply()
        }

        binding.b1.setOnClickListener {
            binding.back.setBackgroundColor(Color.RED)
            saveColor(Color.RED)
        }
        binding.b2.setOnClickListener {
            binding.back.setBackgroundColor(Color.BLUE)
            saveColor(Color.BLUE)
        }



    }
}