package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.adapter.MainAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.utils.SampleData

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.apply {
            MainRV.adapter=MainAdapter(SampleData.collections)

        }




    }




}