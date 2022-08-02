package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broadcastreceiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var broadcastReceiver: BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}