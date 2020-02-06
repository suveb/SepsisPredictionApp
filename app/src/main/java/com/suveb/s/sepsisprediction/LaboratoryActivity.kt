package com.suveb.s.sepsisprediction

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_laboratory.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class LaboratoryActivity : AppCompatActivity(), KodeinAware {

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
        setContentView(R.layout.activity_laboratory)

        btn_next2.setOnClickListener {
            dataClass.apply {
                BaseExcess = excess_bicarbonate.text.toString().toFloat()
                HCO3 = bicarbonate.text.toString().toFloat()
                FiO2 = inspired_oxygen.text.toString().toFloat()
                pH = ph.text.toString().toFloat()
                PaCO2 = partial_pressure.text.toString().toFloat()
                SaO2 = o_saturation.text.toString().toFloat()
                AST = aspartate.text.toString().toFloat()
                BUN = blood_urea.text.toString().toFloat()
                Alkalinephos = alkaline.text.toString().toFloat()
                Calcium = calcium.text.toString().toFloat()
                Chloride = chloride.text.toString().toFloat()
                Creatinine = creatinine.text.toString().toFloat()
                Bilirubin_direct = bilirubin.text.toString().toFloat()
                Glucose = serum_glucose.text.toString().toFloat()
                Lactate = lactic_acid.text.toString().toFloat()
                Magnesium = magnesium.text.toString().toFloat()
                Phosphate = phosphate.text.toString().toFloat()
                Potassium = potassium.text.toString().toFloat()
                Bilirubin_total = bilirubin.text.toString().toFloat()
                TroponinI = troponin.text.toString().toFloat()
                Hct= hematocrit.text.toString().toFloat()
                Hgb = haemoglobin.text.toString().toFloat()
                PTT = thrombin_time.text.toString().toFloat()
                WBC = leukocyte.text.toString().toFloat()
                Fibrinogen = fibrinogen.text.toString().toFloat()
                Platelets = platelets.text.toString().toFloat()
                startActivity(Intent(this@LaboratoryActivity,DemographicActivity::class.java))
            }
        }

    }
}
