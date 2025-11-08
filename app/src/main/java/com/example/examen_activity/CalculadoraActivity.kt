package com.example.examen_activity

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculadoraActivity : AppCompatActivity() {


    private lateinit var txtNum1 : EditText

    private lateinit var txtNum2 : EditText
    private lateinit var spnOperaciones : Spinner

    private lateinit var txtResultado : TextView

    private lateinit var btnCalcular : Button

    private lateinit var txtNombreCalc : TextView

    private lateinit var btnLimpiar : Button

    private lateinit var btnRegresar : Button

    private var pos : Int = 0;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        iniciarComponentes()
        eventosClick()
    }


    fun iniciarComponentes(){

        txtNum1 = findViewById(R.id.txtNum1) as EditText
        txtNum2 = findViewById(R.id.txtNum2) as EditText
        txtNombreCalc = findViewById(R.id.txtNombreCalc) as TextView
        txtResultado = findViewById(R.id.txtResultado) as TextView
        btnCalcular = findViewById(R.id.btnCalcular) as Button
        btnRegresar = findViewById(R.id.btnRegresar) as Button
        btnLimpiar = findViewById(R.id.btnLimpiar) as Button
        spnOperaciones = findViewById(R.id.spnOperaciones) as Spinner

        val items = resources.getStringArray(R.array.strOperaciones)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        spnOperaciones.adapter = adapter

        var strNombre : String = intent.getStringExtra("nombre").toString()
        txtNombreCalc.text = strNombre.toString()
    }


    fun eventosClick(){

        spnOperaciones.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long){
                pos = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        btnCalcular.setOnClickListener({

            if(txtNum1.text.toString().contentEquals("") ||
                txtNum2.text.toString().contentEquals("")){
                Toast.makeText(this, "Faltó capturar algún dato", Toast.LENGTH_SHORT).show()
            }
            else {

                var operaciones = Operaciones()

                operaciones.num1 = txtNum1.text.toString().toFloat()
                operaciones.num2 = txtNum2.text.toString().toFloat()



                val resultado = when(pos){
                    0-> operaciones.sumaOperacion() //Suma
                    1->operaciones.restaOperacion() //Resta
                    2-> operaciones.multiplicacionOperacion() //Multiplicacion
                    3-> operaciones.divisionOperacion() //Division
                    else -> 0.0f
                }
                txtResultado.setText(resultado.toString())
            }
        })

        btnLimpiar.setOnClickListener({
            txtNum1.setText("")
            txtNum2.setText("")
            txtResultado.setText("Resultado")
        })

        btnRegresar.setOnClickListener({
            finish()
        })

    }
}