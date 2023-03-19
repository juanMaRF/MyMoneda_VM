package com.juanrivera.mymoneda_vm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.juanrivera.mymoneda_vm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        val splashscreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        var plata:Double = 0.0
        var resultado:Double = 0.0

        mainBinding.buttonConvertir.setOnClickListener {
            if(mainBinding.catiEditText.text.toString() == ""){
                Toast.makeText(applicationContext,"Espacio vacio", Toast.LENGTH_LONG).show()  //LENGTH_SHORT
            }else {
                plata = mainBinding.catiEditText.text.toString().toDouble()
                val mon1 = mainBinding.menuMoneda.selectedItemPosition
                val mon2 = mainBinding.menuMoneda2.selectedItemPosition
                Log.d("menu 1 : ", mon1.toString())
                Log.d("menu 2 : ", mon2.toString())
                if (mon1 == 0) {
                    if (mon2 == 1) {
                        resultado = plata * 0.94
                        Log.d("Resultado = ", resultado.toString())
                    } else if (mon2 == 2) {
                        resultado = plata * 4722.83
                    } else if (mon2 == 0) {
                        resultado = plata
                    }
                } else if (mon1 == 1) {
                    if (mon2 == 0) {
                        resultado = plata * 1.06
                    } else if (mon2 == 2) {
                        resultado = plata * 5028.16
                    } else if (mon2 == 1) {
                        resultado = plata
                    }
                } else if (mon1 == 2) {
                    if (mon2 == 0) {
                        resultado = plata * 0.00021
                    } else if (mon2 == 1) {
                        resultado = plata * 0.00020
                    } else if (mon2 == 2) {
                        resultado = plata
                    }
                }
                mainBinding.resultTextView.text = resultado.toString()
            }
        }

        setContentView(mainBinding.root)
    }
}