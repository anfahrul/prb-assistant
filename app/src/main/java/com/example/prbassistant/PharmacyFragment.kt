package com.example.prbassistant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prbassistant.Adapter.ListMedicineAdapter

class PharmacyFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var rvMedicine: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<ListMedicineAdapter.ListViewHolder>? = null
    private var list: ArrayList<Medicine> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        list.addAll(MedicinesData.listData)
        return inflater.inflate(R.layout.fragment_pharmacy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvMedicine = view.findViewById(R.id.rv_heroes)
        rvMedicine.setHasFixedSize(true)

        rvMedicine.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListMedicineAdapter(list)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        list.clear()
    }
}