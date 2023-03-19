package com.juanrivera.mymoneda_vm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.juanrivera.mymoneda_vm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        val splashscreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        var resultObserver = Observer<Double>{
            mainBinding.resultTextView.text = it.toString()
        }
        mainViewModel.resultado.observe(this,resultObserver)

        mainBinding.buttonConvertir.setOnClickListener {
            if(mainBinding.catiEditText.text.toString() == ""){
                Toast.makeText(applicationContext,"Espacio vacio", Toast.LENGTH_LONG).show()  //LENGTH_SHORT
            }else {
                mainViewModel.Conv(mainBinding.menuMoneda.selectedItemPosition,mainBinding.menuMoneda2.selectedItemPosition,mainBinding.catiEditText.text.toString().toDouble())
            }
        }

        setContentView(mainBinding.root)
    }
}