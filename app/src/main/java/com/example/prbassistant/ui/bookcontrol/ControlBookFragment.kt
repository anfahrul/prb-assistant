package com.example.prbassistant.ui.bookcontrol

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.prbassistant.R
import com.example.prbassistant.model.PatienProfile
import com.example.prbassistant.model.PatienProfileData

class ControlBookFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_control_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var name: String = PatienProfileData.patienProfileData[0]
        val medicalRecordNumber: String = PatienProfileData.patienProfileData[1]
        val hospital: String = PatienProfileData.patienProfileData[2]
        val diagnosis: String = PatienProfileData.patienProfileData[3]
        val BPJSNumber: String = PatienProfileData.patienProfileData[4]
        val birthDate: String = PatienProfileData.patienProfileData[5]
        val address: String = PatienProfileData.patienProfileData[6]
        val phoneNumber: String = PatienProfileData.patienProfileData[7]

        var tvPatienName: TextView = view.findViewById(R.id.tv_controlbook_patien_name)
        var tvPatienMedicalRecordNum: TextView = view.findViewById(R.id.tv_controlbook_patien_medical_record)
        var btnProfileDetail: Button = view.findViewById(R.id.btn_controlbook_profile_detail)

        tvPatienName.text = name
        tvPatienMedicalRecordNum.text = medicalRecordNumber

        val patienProfile = PatienProfile(name, medicalRecordNumber, hospital, diagnosis, BPJSNumber, birthDate, address, phoneNumber)
        btnProfileDetail.setOnClickListener{
            val action = ControlBookFragmentDirections.actionControlBookFragmentToProfileFragment(patienProfile)
            findNavController().navigate(action)
        }
    }

}