package com.example.prbassistant.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.prbassistant.R
import com.example.prbassistant.model.ControlBook

class ListControlBookAdapter(private val listControlBook: ArrayList<ControlBook>): RecyclerView.Adapter<ListControlBookAdapter.ListViewHolder>() {
 inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvDate: TextView = itemView.findViewById(R.id.tv_controlbook_date)
        var tvDoctorName: TextView = itemView.findViewById(R.id.tv_controlbook_doctor_name)
        var tvMedicalStatus: TextView = itemView.findViewById(R.id.tv_controlbook_medical_status)
        var tvNote: TextView = itemView.findViewById(R.id.tv_controlbook_note)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_book, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val bookControl = listControlBook[position]
        holder.tvDate.text = bookControl.dateCheck
        holder.tvDoctorName.text = bookControl.doctorName
        holder.tvMedicalStatus.text = bookControl.medicalStatus
        holder.tvNote.text = bookControl.note
    }

    override fun getItemCount(): Int {
        return listControlBook.size
    }
}