package com.example.prbassistant.ui.pharmacyreminder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.prbassistant.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class SetReminderOnceDayFragment : Fragment() {
    private var choise: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set_reminder_once_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val doseChoiceGroup: ChipGroup = view.findViewById(R.id.choice_reminder_dose)
        doseChoiceGroup.setOnCheckedChangeListener { chipGroup, checkedId ->
            val titleOrNull = chipGroup.findViewById<Chip>(checkedId)?.text
            choise = Integer.parseInt(titleOrNull.toString())
            Toast.makeText(chipGroup.context, "$titleOrNull" ?: "No Choice", Toast.LENGTH_SHORT).show()
        }

        val btnSaveReminderOnceDay: Button = view.findViewById(R.id.btn_save_count_reminder_onceday)
        btnSaveReminderOnceDay.setOnClickListener{
            val action = SetReminderOnceDayFragmentDirections.actionSetReminderOnceDayFragmentToAddMedicineFragment(choise)
            findNavController().navigate(action)
        }
    }
}