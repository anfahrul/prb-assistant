package com.example.prbassistant.ui.pharmacyreminder

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prbassistant.R
import com.example.prbassistant.adapter.ListTimeReminderAdapter
import com.example.prbassistant.model.MedicineReminder
import com.example.prbassistant.model.TimeReminder
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.log
import kotlin.time.Duration.Companion.hours

class AddMedicineFragment : Fragment(), View.OnClickListener {
    var tvReminderTime: TextView? = null
    private var timeReminderAdapter: ListTimeReminderAdapter? = null
    private lateinit var rvTimeReminder: RecyclerView
    private var data: ArrayList<TimeReminder> = arrayListOf()
    private var setData: ArrayList<Calendar> = arrayListOf()
    private val args by navArgs<AddMedicineFragmentArgs>()
    private var alarmMgr: AlarmManager? = null
    private lateinit var alarmIntent: PendingIntent

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

        val btnSetReminderCountOnceday: Button =
            view.findViewById(R.id.btn_set_reminder_count_onceday)
        tvReminderTime = view.findViewById(R.id.text_reminder_time)
        val tvReminderOnceDay: TextView = view.findViewById(R.id.text_reminder_onceday)
        val btnSaveReminder: Button = view.findViewById(R.id.btn_save_reminder)
        val edtMedicineName: EditText = view.findViewById(R.id.edt_medicine_name)
        val edtRepetition: EditText = view.findViewById(R.id.edt_reminder_medicine_count_day)

        rvTimeReminder = view.findViewById(R.id.rv_time_reminder)
        rvTimeReminder.setHasFixedSize(true)

        rvTimeReminder.layoutManager = LinearLayoutManager(activity)
        timeReminderAdapter = ListTimeReminderAdapter(data)
        rvTimeReminder.adapter = timeReminderAdapter

        tvReminderOnceDay.text = "${args.countOnceDay} Kali sehari"
        btnSetReminderCountOnceday.setOnClickListener(this)

        createNotificationChannel()

        timeReminderAdapter!!.setOnItemClickCallback(object :
            ListTimeReminderAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Calendar) {
                setData.add(data)
                Toast.makeText(context, "Set success ${data.timeInMillis}", Toast.LENGTH_SHORT)
                    .show()

                btnSaveReminder.setOnClickListener {
                    for (set in setData) {
                        var ticks = System.currentTimeMillis().toInt()
                        setAlarm(set.timeInMillis, ticks)
                        Thread.sleep(3000)
                    }

                    var allTime = ""
                    val formatter = SimpleDateFormat("HH:mm")
                    for (i in 0..setData.size-1) {
                        val formatted = formatter.format(setData[i].timeInMillis)
                        allTime = allTime.plus(", ").plus(formatted.toString())
                    }

                    var medicineReminder = MedicineReminder(
                        edtMedicineName.text.toString(),
                        tvReminderOnceDay.text.toString(),
                        allTime,
                        edtRepetition.text.toString()
                    )
                    val action =
                        AddMedicineFragmentDirections.actionAddMedicineFragmentToMedicineReminderFragment3(medicineReminder)
                    findNavController().navigate(action)
                }
            }
        })
    }

    private fun setAlarm(date: Long, ticks: Int) {
        alarmMgr = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmIntent = Intent(context, AlarmReceiver::class.java).let { intent ->
            PendingIntent.getBroadcast(context, ticks, intent, 0)
        }

        // AlarmManager interval
        alarmMgr?.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            date,
            AlarmManager.INTERVAL_DAY,
            alarmIntent
        )

        Toast.makeText(context, "Alarm set successfull", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_set_reminder_count_onceday -> {
                val action =
                    AddMedicineFragmentDirections.actionAddMedicineFragmentToSetReminderOnceDayFragment()
                findNavController().navigate(action)
            }
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = "prbassistantreminderchannel"
            val desc = "Channel for medicine reminder"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("medicinereminder", name, importance)
            channel.description = desc
            val notificationManager = activity?.getSystemService(
                NotificationManager::class.java
            )

            notificationManager?.createNotificationChannel(channel)
        }
    }
}