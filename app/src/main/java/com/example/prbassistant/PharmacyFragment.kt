package com.example.prbassistant

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prbassistant.adapter.ListMedicineAdapter
import com.example.prbassistant.model.Medicine
import com.example.prbassistant.model.MedicinesData
import kotlinx.coroutines.Dispatchers.Main

class PharmacyFragment : Fragment(), View.OnClickListener {
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

        var btnTebus = view.findViewById<Button>(R.id.btn_tebus)
        btnTebus.setOnClickListener(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        list.clear()
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_tebus -> {
                val intent = Intent (getActivity(), PharmacyActivity::class.java)
                intent.putExtra(PharmacyListFragment.EXTRA_ID_RECEIPE, "192837465")
                getActivity()?.startActivity(intent)
            }
        }
    }
}