package com.suveb.s.sepsisprediction

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_scrolling.*
import kotlinx.android.synthetic.main.content_scrolling.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class ScrollingActivity : AppCompatActivity(), KodeinAware {

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
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)

        val predictor = Predictor(this)

        val pred = predictor.predict(dataClass) * 100

        txv_pred.text = pred.toString()+"%"
        if(pred < 40)
            txv_pred.setTextColor(Color.GREEN)
        else if (pred <60)
            txv_pred.setTextColor(Color.parseColor("#FFA500"))
        else
            txv_pred.setTextColor(Color.RED)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
