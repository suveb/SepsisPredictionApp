package com.suveb.s.sepsisprediction

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_vital.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class VitalActivity : AppCompatActivity(),KodeinAware {

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
        setContentView(R.layout.activity_vital)

        btn_next1.setOnClickListener {
            dataClass.apply {
                HR = heart_rate.text.toString().toFloat()
                O2Sat = pulse_oximetry.text.toString().toFloat()
                Temp = temprature.text.toString().toFloat()
                SBP = systolic_bp.text.toString().toFloat()
                MAP = arterial_pressure.text.toString().toFloat()
                DBP = diastolic_bp.text.toString().toFloat()
                Resp = resp_rate.text.toString().toFloat()
                EtCO2 = end_tidal.text.toString().toFloat()
                startActivity(Intent(this@VitalActivity,LaboratoryActivity::class.java))
            }
        }
    }
}
