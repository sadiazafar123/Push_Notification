package com.example.pushnotificationapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

 class MyBroadCastReceiver: BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action== Intent.ACTION_AIRPLANE_MODE_CHANGED){
            val isAirPlaneModeEnabled = intent.getBooleanExtra("state",false)
            if (isAirPlaneModeEnabled) {
                Toast.makeText(context, "air plane mode on", Toast.LENGTH_SHORT)
                    .show()

            }else{
                Toast.makeText(context, "air plane mode off", Toast.LENGTH_SHORT)
                    .show()


            }
        }
        if(intent?.action== Intent.ACTION_PACKAGE_ADDED){
            Toast.makeText(context, "new app is changed", Toast.LENGTH_SHORT).show()

        }
        if(intent?.action== Intent.ACTION_PACKAGE_REMOVED){
            Toast.makeText(context, "new app is changed", Toast.LENGTH_SHORT).show()

        }
        if (intent?.action== Intent.ACTION_POWER_CONNECTED){
            Toast.makeText(context, "charger is connected", Toast.LENGTH_SHORT).show()


        }
        if (intent?.action == Intent.ACTION_PACKAGE_REMOVED){
            Toast.makeText(context, "deleted", Toast.LENGTH_SHORT).show()


        }



    }

}
