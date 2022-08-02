package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.broadcastreceiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var broadcastReceiver: BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //context registered broadcast receiver
        broadcastReceiver=object :BroadcastReceiver(){
            override fun onReceive(p0: Context?, p1: Intent?) {
                checkInternetConnection()
            }
        }

        val intentFilter=IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
        registerReceiver(broadcastReceiver,intentFilter)

    }

    private fun checkInternetConnection() {
        val checkNet=NetworkChecker(this)
        if(checkNet.isInternetConnected){
            binding.txtShowConect.text="Connected!"
        }else{
            binding.txtShowConect.text="Disconnected!"
        }
    }

    override fun onDestroy() {
        unregisterReceiver(broadcastReceiver)
        super.onDestroy()
    }
}