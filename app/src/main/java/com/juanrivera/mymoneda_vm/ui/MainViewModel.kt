package com.juanrivera.mymoneda_vm.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val resultado: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

    fun Conv(mon1:Int, mon2:Int, plata:Double){
        if (mon1 == 0) {
            if (mon2 == 1) {
                resultado.value = plata * 0.94
            } else if (mon2 == 2) {
                resultado.value = plata * 4722.83
            } else if (mon2 == 0) {
                resultado.value = plata
            }
        } else if (mon1 == 1) {
            if (mon2 == 0) {
                resultado.value = plata * 1.06
            } else if (mon2 == 2) {
                resultado.value = plata * 5028.16
            } else if (mon2 == 1) {
                resultado.value = plata
            }
        } else if (mon1 == 2) {
            if (mon2 == 0) {
                resultado.value = plata * 0.00021
            } else if (mon2 == 2) {
                resultado.value = plata
            } else if (mon2 == 1) {
                resultado.value = plata * 0.00020
            }
        }
    }
}