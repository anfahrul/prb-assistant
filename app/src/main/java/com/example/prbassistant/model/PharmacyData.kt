package com.example.prbassistant.model

object PharmacyData {
    private val pharmacyName = arrayOf(
        "Apotek Kimia Farma Wiyung",
        "Apotik Optima",
        "Apotik KIMIA FARMA 304",
        "Apotik 2 Oscar",
        "Apotik KIMIA FARMA 25"
    )

    private val pharmacyAddress = arrayOf(
        "Jl. Raya Menganti A-17",
        "Jl. Raya Rungkut Mapan Fa-7",
        "Jl. Dharmawangsa No.28",
        "Jl Raya Darmo No. 2-4 Surabaya",
        "Perak Timur 166"
    )

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