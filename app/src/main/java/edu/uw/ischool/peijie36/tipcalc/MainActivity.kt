package edu.uw.ischool.peijie36.tipcalc

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val amountInput = findViewById<EditText>(R.id.et_amount)
        val tipButton = findViewById<Button>(R.id.btn_tip)
        amountInput.addTextChangedListener {
            tipButton.isEnabled = !amountInput.text.toString().isBlank()
        }
    }
    
    fun calculateTip(view: View) {
        val amountInput = findViewById<EditText>(R.id.et_amount)
        val tip : Double = amountInput.text.toString().toDouble() * 0.15
        Toast.makeText(this,"$${round2DecimalPlaces(tip)}", Toast.LENGTH_LONG).show()
    }

    private fun round2DecimalPlaces(input: Double): Double {
        return String.format("%.2f", input).toDouble()
    }
}