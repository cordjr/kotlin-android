package com.example.cordjr.forecastapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.cordjr.forecastapp.data.Request
import com.example.cordjr.forecastapp.domain.commands.ForecastCommand
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {
    private val items = listOf("Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecastList.layoutManager = LinearLayoutManager(this)

        doRequest()

    }

    fun doRequest(){
        val url = "http://api.openweathermap.org/data/2.5/forecast/daily?APPID=15646a06818f61f7b8d7823ca833e1ce&zip=94043&mode=json&units=met\\3ric&cnt=7"
        doAsync {
            val result =  ForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result)
            }
        }
    }
}
