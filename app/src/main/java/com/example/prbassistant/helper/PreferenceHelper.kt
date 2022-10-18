package com.example.prbassistant.helper

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper (context: Context) {
    private val PREF_NAME = "share_pref_prbassistant"
    private var sharedPref: SharedPreferences
    val editor: SharedPreferences.Editor

    init {
        sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPref.edit()
    }

    fun put(key: String, value: Int) {
        editor.putInt(key, value)
            .apply()
    }

    fun getInt(key: String): Int? {
        return sharedPref.getInt(key, 0)
    }
}