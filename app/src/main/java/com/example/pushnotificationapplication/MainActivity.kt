package com.example.pushnotificationapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.*
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var myBroadCastReceiver:MyBroadCastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myBroadCastReceiver= MyBroadCastReceiver()
       // applicationContext.contentResolver

        val intentFilter=IntentFilter(ACTION_PACKAGE_ADDED)
        val intentFilter2= IntentFilter(ACTION_DELETE)
        val intentFilter3= IntentFilter(ACTION_AIRPLANE_MODE_CHANGED)
        var intentFilter4=IntentFilter(ACTION_POWER_CONNECTED)
        val intentFilter5=IntentFilter(ACTION_PACKAGE_REMOVED)

        registerReceiver(myBroadCastReceiver,intentFilter)
        registerReceiver(myBroadCastReceiver,intentFilter2)
        registerReceiver(myBroadCastReceiver,intentFilter3)
        registerReceiver(myBroadCastReceiver,intentFilter4)
        registerReceiver(myBroadCastReceiver,intentFilter5)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::myBroadCastReceiver.isInitialized)
            unregisterReceiver(myBroadCastReceiver)
    }
/*
   inner class MyBroadCastReceiver:BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action==ACTION_AIRPLANE_MODE_CHANGED){
                val isAirPlaneModeEnabled=intent.getBooleanExtra("state",false)
                if (isAirPlaneModeEnabled) {
                    Toast.makeText(this@MainActivity, "air plane mode on", Toast.LENGTH_SHORT)
                        .show()

                }else{
                    Toast.makeText(this@MainActivity, "air plane mode off", Toast.LENGTH_SHORT)
                        .show()


                }
            }
            if(intent?.action==ACTION_PACKAGE_ADDED){
                Toast.makeText(this@MainActivity, "new app is changed", Toast.LENGTH_SHORT).show()


            }
            if (intent?.action==ACTION_POWER_CONNECTED){
                Toast.makeText(this@MainActivity, "charger is connected", Toast.LENGTH_SHORT).show()


            }
            if (intent?.action==ACTION_DELETE){
                Toast.makeText(this@MainActivity, "deleted", Toast.LENGTH_SHORT).show()


            }



        }

    }
*/

}