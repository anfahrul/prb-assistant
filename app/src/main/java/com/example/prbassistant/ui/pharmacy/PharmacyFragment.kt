package com.example.prbassistant.ui.pharmacy

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prbassistant.R
import com.example.prbassistant.adapter.ListControlBookAdapter
import com.example.prbassistant.adapter.ListDrugAdapter
import com.example.prbassistant.api.RetrofitClient
import com.example.prbassistant.helper.Constant
import com.example.prbassistant.helper.PreferenceHelper
import com.example.prbassistant.model.*
import com.google.android.material.chip.Chip
import retrofit2.Call
import retrofit2.Response

class PharmacyFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private lateinit var rvMedicine: RecyclerView
    private var listDrugAdapter: ListDrugAdapter? = null
    private var list = ArrayList<Drug>()
    private var recipe = Recipe()
    private var pharmacySelected = Pharmacy()
    lateinit var sharedPref: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pharmacy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvMedicine = view.findViewById(R.id.rv_heroes)
        rvMedicine.setHasFixedSize(true)
        rvMedicine.layoutManager = LinearLayoutManager(activity)

        sharedPref = PreferenceHelper(requireContext())
        val medicalRecordNumber = sharedPref.getInt(Constant.PREF_MEDICAL_RECORD_NUMBER).toString()

        RetrofitClient.instance.getRecipe(medicalRecordNumber)
            .enqueue(object : retrofit2.Callback<Recipe> {
                @SuppressLint("ResourceAsColor")
                override fun onResponse(
                    call: Call<Recipe>,
                    response: Response<Recipe>
                ) {
                    var result = response.body()
                    if (result != null) {
                        recipe = Recipe(
                            result.recipeId,
                            result.claimStatus,
                        )

                        var tvIdRecipe: TextView =
                            view.findViewById(R.id.text_id_receipe)
                        var tvClaimStatus: TextView =
                            view.findViewById(R.id.text_status)
                        var chip: Chip =
                            view.findViewById(R.id.text_status)

                        tvIdRecipe.text = recipe.recipeId.toString()
                        tvClaimStatus.text = recipe.claimStatus

                        if (recipe.claimStatus == "Belum diklaim") {
                            chip.chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(context!!, R.color.yellow))
                        } else if (recipe.claimStatus == "Diklaim") {
                            chip.chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(context!!, R.color.green_light))
                        }
                    }
                }

                override fun onFailure(call: Call<Recipe>, t: Throwable) {
                }
            })

        RetrofitClient.instance.getMedicineOnRecipe(medicalRecordNumber)
            .enqueue(object : retrofit2.Callback<Medicine> {
                override fun onResponse(
                    call: Call<Medicine>,
                    response: Response<Medicine>
                ) {
                    response.body()?.let { list.addAll(it.drugs) }
                    listDrugAdapter = ListDrugAdapter(list)
                    rvMedicine.adapter = listDrugAdapter
                }

                override fun onFailure(call: Call<Medicine>, t: Throwable) {
                }

            })

        RetrofitClient.instance.getPharmacyOnRecipe(medicalRecordNumber)
            .enqueue(object : retrofit2.Callback<PharmacySelected> {
                override fun onResponse(
                    call: Call<PharmacySelected>,
                    response: Response<PharmacySelected>
                ) {
                    var result = response.body()
                    if (result != null) {
                        pharmacySelected = Pharmacy(
                            result.pharmacy.pharmacyId,
                            result.pharmacy.name,
                            result.pharmacy.address,
                        )

                        val tvPharmacy: TextView =
                            view.findViewById(R.id.text_apotek_name)
                        val tvAddress: TextView =
                            view.findViewById(R.id.text_address)

                        tvPharmacy.text = pharmacySelected.name
                        tvAddress.text = pharmacySelected.address
                    }
                }

                override fun onFailure(call: Call<PharmacySelected>, t: Throwable) {
                }
            })


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
                val idReceipt = recipe.recipeId.toString()
                val action = PharmacyFragmentDirections.actionPharmacyFragmentToPharmacyListFragment(idReceipt)
                findNavController().navigate(action)
            }
        }
    }
}