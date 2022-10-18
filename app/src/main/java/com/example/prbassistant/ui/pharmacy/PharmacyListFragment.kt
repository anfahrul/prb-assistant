package com.example.prbassistant.ui.pharmacy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prbassistant.R
import com.example.prbassistant.adapter.ListControlBookAdapter
import com.example.prbassistant.adapter.ListPharmacyAdapter
import com.example.prbassistant.api.RetrofitClient
import com.example.prbassistant.helper.Constant
import com.example.prbassistant.helper.PreferenceHelper
import com.example.prbassistant.model.ControlBook
import com.example.prbassistant.model.Pharmacy
import com.example.prbassistant.model.PharmacyData
import com.example.prbassistant.model.RequestPharmacy
import com.example.prbassistant.ui.bookcontrol.ProfileFragmentArgs
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PharmacyListFragment : Fragment() {
    private val args by navArgs<PharmacyListFragmentArgs>()
    private lateinit var rvPharmacy: RecyclerView
    private var listPharmacyAdapter: ListPharmacyAdapter? = null
    private var list: ArrayList<Pharmacy> = arrayListOf()
    lateinit var sharedPref: PreferenceHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pharmacy_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = PreferenceHelper(requireContext())
        val medicalRecordNumber = sharedPref.getInt(Constant.PREF_MEDICAL_RECORD_NUMBER).toString()

        val id_receipt = args.idReceipt
        rvPharmacy = view.findViewById(R.id.rv_pharmacy)
        rvPharmacy.setHasFixedSize(true)
        rvPharmacy.layoutManager = LinearLayoutManager(activity)

        RetrofitClient.instance.getPharmacy()
            .enqueue(object : retrofit2.Callback<ArrayList<Pharmacy>> {
                override fun onResponse(
                    call: Call<ArrayList<Pharmacy>>,
                    response: Response<ArrayList<Pharmacy>>
                ) {
                    response.body()?.let { list.addAll(it) }
                    listPharmacyAdapter = ListPharmacyAdapter(list, id_receipt)
                    rvPharmacy.adapter = listPharmacyAdapter

                    listPharmacyAdapter?.setOnItemClickCallback(object :
                        ListPharmacyAdapter.OnItemClickCallback {
                        override fun onItemClicked(data: Pharmacy, id_receipt: String?) {
                            updateDataOnDatabase(data.pharmacyId, medicalRecordNumber)
                            sendSuccessData(data, id_receipt)

                        }

                    })
                }

                override fun onFailure(call: Call<ArrayList<Pharmacy>>, t: Throwable) {
                }

            })
    }

    private fun updateDataOnDatabase(pharmacyId: Int, medicalRecordNumber: String) {
        var requestData = RequestPharmacy(
            claimStatus = "Diklaim",
            pharmacyId = pharmacyId
        )
        RetrofitClient.instance.updatePharmacy(requestData, medicalRecordNumber).enqueue(
            object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<String>,
                    response: Response<String>
                ) {
                    Toast.makeText(context, "${response.body()}", Toast.LENGTH_SHORT).show()
                }

            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        list.clear()
    }

    private fun sendSuccessData(pharmacy: Pharmacy, id_receipt: String?) {
        val action =
            PharmacyListFragmentDirections.actionPharmacyListFragmentToClaimSuccessFragment2(
                pharmacy,
                id_receipt
            )
        findNavController().navigate(action)
    }
}