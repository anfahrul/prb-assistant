package com.example.prbassistant.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.prbassistant.R
import com.example.prbassistant.model.MedicineReminder

class ListMedicineReminderAdapter(private val listMedicineReminder: ArrayList<MedicineReminder>): RecyclerView.Adapter<ListMedicineReminderAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvReminderMedicineName: TextView = itemView.findViewById(R.id.tv_reminder_medicine_name)
        var tvReminderRepetitionOnceDay: TextView = itemView.findViewById(R.id.tv_reminder_repetion_once_day)
        var tvReminderTime: TextView = itemView.findViewById(R.id.tv_reminder_time)
        var tvReminderRepetition: TextView = itemView.findViewById(R.id.tv_reminder_repetion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_reminder, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val medicineReminder = listMedicineReminder[position]
        holder.tvReminderMedicineName.text = medicineReminder.name
        holder.tvReminderRepetitionOnceDay.text = medicineReminder.repetionOnceDay
        holder.tvReminderTime.text = "Mengingatkan pada jam ${medicineReminder.time}"
        holder.tvReminderRepetition.text = "Selama ${medicineReminder.repetion} hari"
    }

    override fun getItemCount(): Int {
        return listMedicineReminder.size
    }
}