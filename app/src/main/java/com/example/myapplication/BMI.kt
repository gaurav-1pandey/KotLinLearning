package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlin.math.roundToInt

class BMI : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        val weight=findViewById<EditText>(R.id.inputwt)
        val height=findViewById<EditText>(R.id.inputht)

        val resval=findViewById<TextView>(R.id.bmi)
        val calc=findViewById<Button>(R.id.calc)
        val status=findViewById<TextView>(R.id.status)

        calc.setOnClickListener({
            var wt=if (weight.text.toString() !="")weight.text.toString().toFloat() else 0f
            var ht=if (height.text.toString() !="") height.text.toString().toFloat() else 0f
            if (wt==0.0f || ht==0.0f ){
                Toast.makeText(this@BMI,"Enter valid inputs",Toast.LENGTH_SHORT).show()
                status.setText("idiot")
                resval.text="0"
            }
            else{

            var ans:Float= (wt/((ht/100)*(ht/100)))
            resval.setText(String.format("%.2f",ans))
//            Log.i("joke",ans.toString()+ht+wt)
            if (ans <=18.5){

                status.setText("UWeight")
                status.setTextColor(ContextCompat.getColor(this,R.color.orange))


            }
            else if (ans>24.9){
                status.setText("OWeight")
                status.setTextColor(ContextCompat.getColor(this,R.color.red))

            }
            else {
                status.setText("Healthy")
                status.setTextColor(ContextCompat.getColor(this,R.color.green))
            }}
        })
    }
}