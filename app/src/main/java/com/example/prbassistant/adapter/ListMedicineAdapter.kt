package com.example.prbassistant.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.prbassistant.model.Medicine
import com.example.prbassistant.R

class ListMedicineAdapter(private val listMedicine: ArrayList<Medicine>): RecyclerView.Adapter<ListMedicineAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var tvName: TextView = itemView.findViewById(R.id.text_receipe_name)
    var tvAmount: TextView = itemView.findViewById(R.id.text_receipe_amount)
    var tvPortion: TextView = itemView.findViewById(R.id.text_receipe_portion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_medicine, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val medicine = listMedicine[position]
        holder.tvName.text = medicine.name
        holder.tvAmount.text = medicine.amount.toString()
        holder.tvPortion.text = medicine.portion.toString()
    }

    override fun getItemCount(): Int {
        return listMedicine.size
    }
}