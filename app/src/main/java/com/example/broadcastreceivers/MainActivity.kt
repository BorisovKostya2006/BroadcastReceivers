package com.example.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val receiver = object : BroadcastReceiver() {
            override fun onReceive(
                context: Context?,
                intent: Intent?
            ) {
                if (intent?.action == "loaded"){
                    val percent = intent.getIntExtra("key_loaded",0)
                    progressBar.progress = percent
                }

            }
        }
        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(MyReceivers.MY_CLICKED)
            sendBroadcast(intent)
        }
        val intentFilter = IntentFilter().apply {
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            addAction(Intent.ACTION_BATTERY_LOW)
            addAction(MyReceivers.MY_CLICKED)
            addAction("loaded")
        }
        registerReceiver(receiver,intentFilter, RECEIVER_EXPORTED )
        Intent(this, MyService::class.java).apply {
            startService(this)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}