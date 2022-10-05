package com.example.prbassistant.ui.bookcontrol

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prbassistant.R
import com.example.prbassistant.adapter.ListControlBookAdapter
import com.example.prbassistant.adapter.ListPharmacyAdapter
import com.example.prbassistant.api.RetrofitClient
import com.example.prbassistant.model.ControlBook
import com.example.prbassistant.model.PatienProfile
import com.example.prbassistant.model.PatienProfileData
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ControlBookFragment : Fragment() {
    private lateinit var rvControlBook: RecyclerView
    private var listControlBookAdapter: ListControlBookAdapter? = null
    private var dataList = ArrayList<ControlBook>()
    private var profileData = PatienProfile()

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_control_book, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        RetrofitClient.instance.getProfile()
            .enqueue(object : retrofit2.Callback<PatienProfile> {
                override fun onResponse(
                    call: Call<PatienProfile>,
                    response: Response<PatienProfile>
                ) {
                    var result = response.body()
                    if (result != null) {
                        profileData = PatienProfile(
                            result.name,
                            result.medicalRecordNumber,
                            result.hospital,
                            result.diagnosis,
                            result.BPJSNumber,
                            result.birthDate,
                            result.address,
                            result.phoneNumber,
                        )

                        val tvPatienName: TextView =
                            view.findViewById(R.id.tv_controlbook_patien_name)
                        val tvPatienMedicalRecordNum: TextView =
                            view.findViewById(R.id.tv_controlbook_patien_medical_record)

                        tvPatienName.text = profileData.name
                        tvPatienMedicalRecordNum.text = profileData.medicalRecordNumber
                    }
                }

                override fun onFailure(call: Call<PatienProfile>, t: Throwable) {
                }
            })

        val btnProfileDetail: Button = view.findViewById(R.id.btn_controlbook_profile_detail)
        btnProfileDetail.setOnClickListener {
            val action = ControlBookFragmentDirections.actionControlBookFragmentToProfileFragment(
                profileData
            )
            findNavController().navigate(action)
        }

        rvControlBook = view.findViewById(R.id.rv_book_control)
        rvControlBook.setHasFixedSize(true)
        rvControlBook.layoutManager = LinearLayoutManager(activity)

        RetrofitClient.instance.getPosts()
            .enqueue(object : retrofit2.Callback<ArrayList<ControlBook>> {
                override fun onResponse(
                    call: Call<ArrayList<ControlBook>>,
                    response: Response<ArrayList<ControlBook>>
                ) {
                    response.body()?.let { dataList.addAll(it) }
                    listControlBookAdapter = ListControlBookAdapter(dataList)
                    rvControlBook.adapter = listControlBookAdapter
                }

                override fun onFailure(call: Call<ArrayList<ControlBook>>, t: Throwable) {
                }

            })
    }

}