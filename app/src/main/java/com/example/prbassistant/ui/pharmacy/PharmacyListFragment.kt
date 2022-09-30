package com.example.prbassistant.ui.pharmacy

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prbassistant.ui.MainActivity
import com.example.prbassistant.R
import com.example.prbassistant.adapter.ListPharmacyAdapter
import com.example.prbassistant.model.Pharmacy
import com.example.prbassistant.model.PharmacyData

class PharmacyListFragment : Fragment(), View.OnClickListener {
    companion object {
        const val EXTRA_ID_RECEIPE = "extra_id_receipe"
    }

    private lateinit var rvPharmacy: RecyclerView
    private var listPharmacyAdapter: ListPharmacyAdapter? = null
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

        val id_receipt = activity?.intent?.getStringExtra(EXTRA_ID_RECEIPE)
        rvPharmacy = view.findViewById(R.id.rv_pharmacy)
        rvPharmacy.setHasFixedSize(true)

        rvPharmacy.layoutManager = LinearLayoutManager(activity)
        listPharmacyAdapter = ListPharmacyAdapter(list, id_receipt)
        rvPharmacy.adapter = listPharmacyAdapter

        listPharmacyAdapter!!.setOnItemClickCallback(object : ListPharmacyAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Pharmacy, id_receipt: String?) {
                showSelectedPharmacy(data)
                sendSuccessData(data, id_receipt)
            }

        })

        val btnBack: Button = view.findViewById(R.id.btn_cancel_claim)

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

    private fun showSelectedPharmacy(pharmacy: Pharmacy) {
        Toast.makeText(this.activity, "Kamu memilih " + pharmacy.name, Toast.LENGTH_SHORT).show()
    }

    private fun sendSuccessData(pharmacy: Pharmacy, id_receipt: String?) {
        val action = PharmacyListFragmentDirections.actionPharmacyListFragment2ToClaimSuccessFragment(pharmacy, id_receipt)
        findNavController().navigate(action)
    }
}