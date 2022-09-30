package com.example.prbassistant.ui.pharmacy

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.prbassistant.ui.MainActivity
import com.example.prbassistant.R

class ClaimSuccessFragment : Fragment(), View.OnClickListener {

    private val args by navArgs<ClaimSuccessFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_claim_success, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pharmacyName: TextView = view.findViewById(R.id.text_desc_name)
        val pharmacyAddress: TextView = view.findViewById(R.id.text_desc_address)
        val idReceipt: TextView = view.findViewById(R.id.text_id_receipt)
        val btnSuccessOk: Button = view.findViewById(R.id.btn_success_oke)

        pharmacyName.text = args.currentPharmacy.name
        pharmacyAddress.text = args.currentPharmacy.address
        idReceipt.text = args.idReceipt

        btnSuccessOk.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_success_oke -> {
                val action = ClaimSuccessFragmentDirections.actionClaimSuccessFragmentToPharmacyFragment()
                findNavController().navigate(action)
            }
        }
    }
}