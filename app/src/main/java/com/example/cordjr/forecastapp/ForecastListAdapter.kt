package com.example.cordjr.forecastapp

import android.support.v7.widget.RecyclerView

import android.view.ViewGroup
import android.widget.TextView
import com.example.cordjr.forecastapp.domain.models.ForecastList

class ForecastListAdapter(private val weakForecast: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }


    override fun getItemCount(): Int = weakForecast.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weakForecast.dailyForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }

    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

}