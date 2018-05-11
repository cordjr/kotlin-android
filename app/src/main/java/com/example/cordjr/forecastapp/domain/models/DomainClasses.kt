package com.example.cordjr.forecastapp.domain.models


data class ForecastModel(val date: String, val description: String, val high: Int, val low: Int)
data class ForecastList(val city: String,
                        val country: String,
                        val dailyForecast: List<ForecastModel>
                        )
