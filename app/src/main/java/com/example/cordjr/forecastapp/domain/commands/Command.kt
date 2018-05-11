package com.example.cordjr.forecastapp.domain.commands

interface Command<out T> {
    fun execute(): T

}