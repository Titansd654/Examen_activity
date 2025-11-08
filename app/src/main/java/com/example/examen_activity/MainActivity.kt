package com.example.examen_activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var txtNombre: TextView
    private lateinit var btnIngresar : Button
    private lateinit var btnCerrar : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        IniciarComponentes()
        eventosClick()
    }

    public fun IniciarComponentes(){
        txtNombre = findViewById(R.id.txtNombre) as EditText
        btnIngresar = findViewById(R.id.btnIngresar) as Button
        btnCerrar = findViewById(R.id.btnCerrar) as Button
    }

    public fun eventosClick(){

        btnIngresar.setOnClickListener({
            if(txtNombre.text.toString().contentEquals("")){
                Toast.makeText(this, "Faltó capturar tu nombre", Toast.LENGTH_SHORT).show();
                txtNombre.requestFocus()
            } else{
                val intent = Intent(this, CalculadoraActivity::class.java)
                intent.putExtra("nombre", txtNombre.text.toString())
                startActivity(intent)
            }
        })
        btnCerrar.setOnClickListener({
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Operaciones Aritmeticas")
            builder.setMessage("Desea Salir de la aplicación?")

            builder.setPositiveButton("Aceptar"){dialog, which ->
                finish()
            }
            builder.setNegativeButton("Cancelar"){dialog, which ->
                Toast.makeText(applicationContext, "Cancelado", Toast.LENGTH_SHORT).show()
            }

            builder.show()
        })

    }

}