package com.example.cordjr.forecastapp.domain.commands

import com.example.cordjr.forecastapp.data.Request
import com.example.cordjr.forecastapp.domain.mappers.ForecastDataMapper
import com.example.cordjr.forecastapp.domain.models.ForecastList

class ForecastCommand(private val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val request = Request(zipCode)
        return ForecastDataMapper().convertFromDataModel(request.execute())

    }
}