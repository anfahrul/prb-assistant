package com.example.prbassistant.ui.pharmacyreminder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.example.prbassistant.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.MaterialTimePicker.INPUT_MODE_KEYBOARD
import com.google.android.material.timepicker.TimeFormat
import android.R.layout.simple_list_item_1
import android.widget.ListAdapter
import android.widget.ListView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prbassistant.adapter.ListMedicineAdapter
import com.example.prbassistant.adapter.ListPharmacyAdapter
import com.example.prbassistant.adapter.ListTimeReminderAdapter
import com.example.prbassistant.model.Pharmacy
import com.example.prbassistant.model.TimeReminder
import com.example.prbassistant.ui.pharmacy.ClaimSuccessFragmentArgs
import com.example.prbassistant.ui.pharmacy.PharmacyListFragmentDirections

class AddMedicineFragment : Fragment(), View.OnClickListener {
    var tvReminderTime: TextView? = null
    private var timeReminderAdapter: ListTimeReminderAdapter? = null
    private lateinit var rvTimeReminder: RecyclerView
    private var data: ArrayList<TimeReminder> = arrayListOf()
    private val args by navArgs<AddMedicineFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        for (i in 1..args.countOnceDay) {
            data.add(TimeReminder("Time $i"))
        }

        return inflater.inflate(R.layout.fragment_add_medicine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSetReminderCountOnceday: Button = view.findViewById(R.id.btn_set_reminder_count_onceday)
        tvReminderTime = view.findViewById(R.id.text_reminder_time)
        val tvReminderOnceDay: TextView = view.findViewById(R.id.text_reminder_onceday)

        rvTimeReminder = view.findViewById(R.id.rv_time_reminder)
        rvTimeReminder.setHasFixedSize(true)

        rvTimeReminder.layoutManager = LinearLayoutManager(activity)
        timeReminderAdapter = ListTimeReminderAdapter(data)
        rvTimeReminder.adapter =  timeReminderAdapter

        tvReminderOnceDay.text = "${args.countOnceDay} Kali sehari"
        btnSetReminderCountOnceday.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_set_reminder_count_onceday -> {
                val action = AddMedicineFragmentDirections.actionAddMedicineFragmentToSetReminderOnceDayFragment()
                findNavController().navigate(action)
            }
        }
    }
}