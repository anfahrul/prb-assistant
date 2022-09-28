package com.example.prbassistant

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prbassistant.adapter.ListMedicineAdapter
import com.example.prbassistant.adapter.ListPharmacyAdapter
import com.example.prbassistant.model.Medicine
import com.example.prbassistant.model.MedicinesData
import com.example.prbassistant.model.Pharmacy
import com.example.prbassistant.model.PharmacyData
import com.google.android.material.bottomnavigation.BottomNavigationView

class PharmacyListFragment : Fragment(), View.OnClickListener {
    private lateinit var rvPharmacy: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<ListPharmacyAdapter.ListViewHolder>? = null
    private var list: ArrayList<Pharmacy> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        list.addAll(PharmacyData.listData)
        return inflater.inflate(R.layout.fragment_pharmacy_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvPharmacy = view.findViewById(R.id.rv_pharmacy)
        rvPharmacy.setHasFixedSize(true)

        rvPharmacy.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListPharmacyAdapter(list)
        }

        var btnBack: Button = view.findViewById(R.id.btn_cancel_claim)
        btnBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_cancel_claim -> {
                val intent = Intent (getActivity(), MainActivity::class.java)
                getActivity()?.startActivity(intent)
            }
        }
    }
}