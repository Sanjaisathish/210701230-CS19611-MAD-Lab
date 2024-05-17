activity_main.xml:

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/etFirstNumber"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="First Number"
        android:inputType="numberDecimal" />

    <EditText
        android:id="@+id/etSecondNumber"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Second Number"
        android:inputType="numberDecimal"
        android:layout_marginTop="8dp" />

    <TextView
        android:id="@+id/tvResult"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Result:"
        android:textSize="18sp"
        android:layout_marginTop="16dp" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginTop="16dp">

        <Button
            android:id="@+id/btnAdd"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="wrap_content"
            android:text="Add" />

        <Button
            android:id="@+id/btnSubtract"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="wrap_content"
            android:text="Subtract"
            android:layout_marginLeft="8dp" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginTop="8dp">

        <Button
            android:id="@+id/btnMultiply"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="wrap_content"
            android:text="Multiply" />

        <Button
            android:id="@+id/btnDivide"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="wrap_content"
            android:text="Divide"
            android:layout_marginLeft="8dp" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginTop="8dp">

        <Button
            android:id="@+id/btnSqrt"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="wrap_content"
            android:text="Square Root" />

        <Button
            android:id="@+id/btnPower"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="wrap_content"
            android:text="Power"
            android:layout_marginLeft="8dp" />
    </LinearLayout>
</LinearLayout>

MainActivity.kt:

package com.example.simplecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etFirstNumber: EditText
    private lateinit var etSecondNumber: EditText
    private lateinit var tvResult: TextView
    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button
    private lateinit var btnSqrt: Button
    private lateinit var btnPower: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etFirstNumber = findViewById(R.id.etFirstNumber)
        etSecondNumber = findViewById(R.id.etSecondNumber)
        tvResult = findViewById(R.id.tvResult)
        btnAdd = findViewById(R.id.btnAdd)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)
        btnSqrt = findViewById(R.id.btnSqrt)
        btnPower = findViewById(R.id.btnPower)

        btnAdd.setOnClickListener {
            performOperation("+")
        }

        btnSubtract.setOnClickListener {
            performOperation("-")
        }

        btnMultiply.setOnClickListener {
            performOperation("*")
        }

        btnDivide.setOnClickListener {
            performOperation("/")
        }

        btnSqrt.setOnClickListener {
            performSingleInputOperation("sqrt")
        }

        btnPower.setOnClickListener {
            performOperation("^")
        }
    }

    private fun performOperation(operation: String) {
        val firstNumber = etFirstNumber.text.toString().toDoubleOrNull()
        val secondNumber = etSecondNumber.text.toString().toDoubleOrNull()

        if (firstNumber == null || secondNumber == null) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val result = when (operation) {
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            "*" -> firstNumber * secondNumber
            "/" -> {
                if (secondNumber == 0.0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                    return
                }
                firstNumber / secondNumber
            }
            "^" -> Math.pow(firstNumber, secondNumber)
            else -> 0.0
        }

        tvResult.text = "Result: $result"
    }

    private fun performSingleInputOperation(operation: String) {
        val firstNumber = etFirstNumber.text.toString().toDoubleOrNull()

        if (firstNumber == null) {
            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show()
            return
        }

        val result = when (operation) {
            "sqrt" -> Math.sqrt(firstNumber)
            else -> 0.0
        }

        tvResult.text = "Result: $result"
    }
}

