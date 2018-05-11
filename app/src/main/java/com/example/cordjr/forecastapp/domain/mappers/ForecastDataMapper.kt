package com.example.cordjr.forecastapp.domain.mappers


import com.example.cordjr.forecastapp.data.Forecast
import com.example.cordjr.forecastapp.data.ForecastResult
import com.example.cordjr.forecastapp.domain.models.ForecastList
import com.example.cordjr.forecastapp.domain.models.ForecastModel
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class ForecastDataMapper {



    private  fun convertFromDataModel(forecast: ForecastResult): ForecastList = ForecastList(forecast.city.name, forecast.city.country, convertForecastListDomain(forecast.list))

    private fun convertForecastListDomain(list: List<Forecast>): List<ForecastModel>{
        return list.mapIndexed { index, forecast->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(index.toLong())
            convertForecasItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecasItemToDomain(forecast: Forecast): ForecastModel{
        return ForecastModel(conertDate((forecast.dt)), forecast.weather.description, forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }

    private fun conertDate(date: Long): String{
        return DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault()).format(date)
    }

}