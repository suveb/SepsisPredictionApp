package com.suveb.s.sepsisprediction

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_demographic.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class DemographicActivity : AppCompatActivity(), KodeinAware {

//    ['HR',  'O2Sat',  'Temp',  'SBP',  'MAP',  'DBP',  'Resp',  'EtCO2',
//    'BaseExcess' ,  'HCO3' ,  'FiO2' ,  'pH' ,  'PaCO2' ,  'SaO2' ,  'AST' ,  'BUN',
//    'Alkalinephos' ,  'Calcium' ,  'Chloride' ,  'Creatinine' ,  'Bilirubin_direct' ,
//    'Glucose' ,  'Lactate',  'Magnesium' ,  'Phosphate' ,  'Potassium' ,
//    'Bilirubin_total' ,  'TroponinI' ,  'Hct' ,  'Hgb' ,  'PTT' ,  'WBC' ,
//    'Fibrinogen' ,  'Platelets' ,  'Age' ,  'Gender' ,  'Unit1' ,  'Unit2' ,
//    'HospAdmTime' ,  'ICULOS' ]

    override val kodein by closestKodein()
    private val dataClass: DataClass by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demographic)

        btn_submit.setOnClickListener {
            dataClass.apply {
                Age = age.text.toString().toFloat()
                Gender = gender.text.toString().toFloat()
                Unit1 = micu.text.toString().toFloat()
                Unit2 = sicu.text.toString().toFloat()
                HospAdmTime = hospital_time.text.toString().toFloat()
                ICULOS = icu_time.text.toString().toFloat()
                startActivity(Intent(this@DemographicActivity,ScrollingActivity::class.java))
            }
        }
    }
}