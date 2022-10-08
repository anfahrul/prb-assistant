package com.example.prbassistant.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.prbassistant.R
import com.example.prbassistant.api.RetrofitClient
import com.example.prbassistant.model.PatienData
import com.example.prbassistant.model.PatienProfile
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private var patientData = PatienProfile()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        val edtMedicalNumber: EditText = findViewById(R.id.edt_medical_record)
        val btnLogin: Button = findViewById(R.id.btn_login)

        btnLogin.setOnClickListener {
            RetrofitClient.instance.getPatient(edtMedicalNumber.text.toString())
                .enqueue(object : retrofit2.Callback<PatienProfile> {
                    override fun onResponse(
                        call: Call<PatienProfile>,
                        response: Response<PatienProfile>
                    ) {
                        if (response.code() == 200) {
                            var result = response.body()
                            if (result != null) {
                                patientData = PatienProfile(
                                    result.name,
                                    result.medicalRecordNumber,
                                    result.hospital,
                                    result.diagnosis,
                                    result.BPJSNumber,
                                    result.birthDate,
                                    result.address,
                                    result.phoneNumber,
                                )
                            }

                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this@LoginActivity, "Nomor Medical Number Tidak Terdaftar", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<PatienProfile>, t: Throwable) {
                    }
                })

        }
    }
}
