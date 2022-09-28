package com.example.prbassistant.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.prbassistant.model.Medicine
import com.example.prbassistant.R
import com.example.prbassistant.model.Pharmacy

class ListPharmacyAdapter(private val listPharmacy: ArrayList<Pharmacy>): RecyclerView.Adapter<ListPharmacyAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var tvName: TextView = itemView.findViewById(R.id.text_pharmacy_name)
    var tvAaddress: TextView = itemView.findViewById(R.id.text_pharmacy_address)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_pharmacy, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val pharmacy = listPharmacy[position]
        holder.tvName.text = pharmacy.name
        holder.tvAaddress.text = pharmacy.address
    }

    override fun getItemCount(): Int {
        return listPharmacy.size
    }
}