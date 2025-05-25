package com.example.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceivers : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when(intent?.action){
            Intent.ACTION_AIRPLANE_MODE_CHANGED ->{
                Toast.makeText(context,"ACTION_AIRPLANE_MODE_CHANGED",Toast.LENGTH_LONG).show()
            }
        }
    }


}