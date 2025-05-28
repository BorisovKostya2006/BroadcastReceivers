package com.example.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceivers : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val turnOn = intent?.getBooleanExtra("state",true)
        when(intent?.action){
            MY_CLICKED -> {
                Toast.makeText(context,"clicked",Toast.LENGTH_LONG).show()
            }
            Intent.ACTION_AIRPLANE_MODE_CHANGED ->{
                Toast.makeText(context,"ACTION_AIRPLANE_MODE_CHANGED, $turnOn",Toast.LENGTH_LONG).show()
            }
            Intent.ACTION_BATTERY_LOW -> {
                Toast.makeText(context,"ACTION_BATTERY_LOW",Toast.LENGTH_LONG).show()
            }
        }
    }
    companion object{
        const val MY_CLICKED = "clicked"
    }


}