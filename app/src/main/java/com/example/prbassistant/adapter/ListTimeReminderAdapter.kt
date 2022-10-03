package com.example.prbassistant.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.prbassistant.R
import com.example.prbassistant.model.Pharmacy
import com.example.prbassistant.model.TimeReminder
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.MaterialTimePicker.INPUT_MODE_KEYBOARD
import com.google.android.material.timepicker.TimeFormat

class ListTimeReminderAdapter(private val listTimeReminder: ArrayList<TimeReminder>) :
    RecyclerView.Adapter<ListTimeReminderAdapter.ListViewHolder>() {
    private var selectedItemPosition: Int = -1
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTime: TextView = itemView.findViewById(R.id.text_reminder_time)
        var btnSetTime: Button = itemView.findViewById(R.id.btn_set_reminder_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_time_reminder, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val time = listTimeReminder[position]
        holder.tvTime.text = time.time

        holder.btnSetTime.setOnClickListener {
            val picker =
                MaterialTimePicker.Builder()
                    .setTimeFormat(TimeFormat.CLOCK_12H)
                    .setHour(11)
                    .setMinute(59)
                    .build()

            MaterialTimePicker.Builder().setInputMode(INPUT_MODE_KEYBOARD)
            val manager = (holder.itemView.context as FragmentActivity).supportFragmentManager
            picker.show(manager, "MainActivity")

            picker.addOnPositiveButtonClickListener {

                val pickedHour: Int = picker.hour
                val pickedMinute: Int = picker.minute

                // check for single digit hour hour and minute
                // and update TextView accordingly
                val formattedTime: String = when {
                    pickedHour > 12 -> {
                        if (pickedMinute < 10) {
                            "${picker.hour - 12}:0${picker.minute} pm"
                        } else {
                            "${picker.hour - 12}:${picker.minute} pm"
                        }
                    }
                    pickedHour == 12 -> {
                        if (pickedMinute < 10) {
                            "${picker.hour}:0${picker.minute} pm"
                        } else {
                            "${picker.hour}:${picker.minute} pm"
                        }
                    }
                    pickedHour == 0 -> {
                        if (pickedMinute < 10) {
                            "${picker.hour + 12}:0${picker.minute} am"
                        } else {
                            "${picker.hour + 12}:${picker.minute} am"
                        }
                    }
                    else -> {
                        if (pickedMinute < 10) {
                            "${picker.hour}:0${picker.minute} am"
                        } else {
                            "${picker.hour}:${picker.minute} am"
                        }
                    }
                }

                holder.tvTime.text = formattedTime
            }
        }
    }

    override fun getItemCount(): Int {
        return listTimeReminder.size
    }

    interface OnItemClickCallback {
        fun onItemClicked()
    }
}