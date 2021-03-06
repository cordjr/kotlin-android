package com.example.cordjr.forecastapp.data

import android.util.Log
import com.google.gson.Gson
import java.net.URL

class Request (val url: String) {

     companion object {
         private const val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
         private const val URL = "http://api.openweathermap.org/data/2.5/"+
                                 "forecast/daily?mode=json&units=metric&cnt=7"
         private const val COMPLETE_URL = "$URL&APPID=$APP_ID&zip="
     }
    fun execute(): ForecastResult{
        val json = URL(COMPLETE_URL).readText()
        Log.d(javaClass.simpleName, json)
        return  Gson().fromJson(json, ForecastResult::class.java)
    }


}