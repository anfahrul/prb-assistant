package com.example.prbassistant

object MedicinesData {
    private val medicineName = arrayOf(
        "Metformin 500 mg",
        "Glucophage XR 500 mg",
        "Diamicron MR 60 mg",
        "Glimepiride 2 mg",
        "Glucophage XR 1000 mg")

    private val medicineAmount = intArrayOf(3,5,2,1,9)
    private val medicinePortion = intArrayOf(2,3,2,1,6)

    val listData: ArrayList<Medicine>
        get() {
            val list = arrayListOf<Medicine>()
            for (position in medicineName.indices) {
                val medicine = Medicine()
                medicine.name = medicineName[position]
                medicine.amount = medicineAmount[position]
                medicine.portion = medicinePortion[position]
                list.add(medicine)
            }
            return list
        }
}