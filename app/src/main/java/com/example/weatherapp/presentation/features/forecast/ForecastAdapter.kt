package com.example.weatherapp.presentation.features.forecast

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.data.model.ForecastResult
import kotlinx.android.synthetic.main.item_forecast.view.*
import java.text.SimpleDateFormat
import java.util.*

class ForecastAdapter :
    ListAdapter<ForecastResult.Daily, ForecastAdapter.ItemViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ForecastResult.Daily>() {
            override fun areItemsTheSame(
                oldItem: ForecastResult.Daily,
                newItem: ForecastResult.Daily
            ): Boolean {
                return oldItem.dt == newItem.dt
            }

            override fun areContentsTheSame(
                oldItem: ForecastResult.Daily,
                newItem: ForecastResult.Daily
            ): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_forecast, parent, false)
        )
    }


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ForecastResult.Daily) = with(itemView) {
            item.dt?.let {
                val date = Date(it.toLong() * 1000)
                this.time.text  = SimpleDateFormat("dd/MM/yyyy").format(date)
            }

            item.weather?.get(0)?.icon?.let {
                image.setImageResource(
                    image.context.resources.getIdentifier(
                        "w$it",
                        "drawable",
                        image.context.packageName
                    )
                )
            }
            this.temp.text = item.temp?.let { it.day ?: 0.0 }.toString().plus("°")
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
