package com.example.prbassistant.ui.pharmacyreminder

import android.app.AlarmManager
import android.app.PendingIntent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.prbassistant.R
import com.example.prbassistant.ui.bookcontrol.ControlBookFragmentDirections
import java.util.Calendar

class MedicineReminderFragment : Fragment(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_medicine_reminder, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnAddNewReminder: Button = view.findViewById(R.id.btn_add_new_reminder)

        btnAddNewReminder.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.btn_add_new_reminder -> {
                val action = MedicineReminderFragmentDirections.actionMedicineReminderFragment3ToAddMedicineFragment(1)
                findNavController().navigate(action)
            }
        }
    }
}