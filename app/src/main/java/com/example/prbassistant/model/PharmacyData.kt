package com.example.prbassistant.model

object PharmacyData {
    private val pharmacyName = arrayOf(
        "Apotik Optima",
        "Apotik 2 Oscar",
        "Apotik KIMIA FARMA 304",
        "Apotik KIMIA FARMA 25",
        "Apotek Kimia Farma Wiyung")

    private val pharmacyAddress = arrayOf(
        "Jl. Raya Rungkut Mapan Fa-7",
        "Jl. Dharmawangsa No.28 ",
        "Perak Timur 166",
        "Jl Raya Darmo No. 2-4 Surabaya",
        "Jl. Raya Menganti A-17 | 031-7668267")

    val listData: ArrayList<Pharmacy>
        get() {
            val list = arrayListOf<Pharmacy>()
            for (position in pharmacyName.indices) {
                val pharmacy = Pharmacy()
                pharmacy.name = pharmacyName[position]
                pharmacy.address = pharmacyAddress[position]
                list.add(pharmacy)
            }
            return list
        }
}