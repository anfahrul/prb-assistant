package com.example.prbassistant.ui.pharmacyreminder

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prbassistant.R
import com.example.prbassistant.adapter.ListMedicineReminderAdapter
import com.example.prbassistant.adapter.ListPharmacyAdapter
import com.example.prbassistant.model.MedicineReminder
import java.util.ArrayList

class MedicineReminderFragment : Fragment() {
    private var listData: ArrayList<MedicineReminder> = arrayListOf()
    private val args by navArgs<MedicineReminderFragmentArgs>()
    private lateinit var rvMedicineReminder: RecyclerView
    private var listMedicineReminderAdapter: ListMedicineReminderAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater!!.inflate(R.menu.reminder_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item!!.itemId
        if (id == R.id.btn_add_new_reminder){
            val action = MedicineReminderFragmentDirections.actionMedicineReminderFragment3ToAddMedicineFragment(1)
            findNavController().navigate(action)
        }

        return super.onOptionsItemSelected(item)
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
        args.medicineReminder?.let { listData?.add(it) }

        rvMedicineReminder = view.findViewById(R.id.rv_reminder)
        rvMedicineReminder.setHasFixedSize(true)

        rvMedicineReminder.layoutManager = LinearLayoutManager(activity)
        listMedicineReminderAdapter = ListMedicineReminderAdapter(listData)
        rvMedicineReminder.adapter = listMedicineReminderAdapter
    }
}