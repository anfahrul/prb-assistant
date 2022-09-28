package com.example.prbassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController

class PharmacyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pharmacy)

        val navController = findNavController(R.id.fragmentPharmacy)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.pharmacyListFragment2))
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}