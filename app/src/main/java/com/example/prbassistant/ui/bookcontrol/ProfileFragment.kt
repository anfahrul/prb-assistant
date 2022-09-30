package com.example.prbassistant.ui.bookcontrol

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.prbassistant.R

class ProfileFragment : Fragment() {
    private val args by navArgs<ProfileFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_profile, container, false)
        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvPatienName: TextView = view.findViewById(R.id.tv_profile_patien_name)
        var tvMedicalRecord: TextView = view.findViewById(R.id.tv_profile_patien_medical_record_num)
        var tvHospital: TextView = view.findViewById(R.id.tv_profile_patien_hospital)
        var tvDiagnosis: TextView = view.findViewById(R.id.tv_profile_patien_diagnisis)
        var tvBPJSNumber: TextView = view.findViewById(R.id.tv_profile_patien_bpjs_num)
        var tvBirthdate: TextView = view.findViewById(R.id.tv_profile_patien_birthdate)
        var tvAddress: TextView = view.findViewById(R.id.tv_profile_patien_address)
        val tvPhoneNumber: TextView = view.findViewById(R.id.tv_profile_patien_phone)

        tvPatienName.text = args.profile.name
        tvMedicalRecord.text = args.profile.medicalRecordNumber
        tvHospital.text = args.profile.hospital
        tvDiagnosis.text = args.profile.diagnosis
        tvBPJSNumber.text = args.profile.BPJSNumber
        tvBirthdate.text = args.profile.birthDate
        tvAddress.text = args.profile.address
        tvPhoneNumber.text = args.profile.phoneNumber
    }
}