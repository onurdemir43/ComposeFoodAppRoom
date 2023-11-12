package com.onurdemir.composefoodapp.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.onurdemir.composefoodapp.entity.Yemekler
import com.onurdemir.composefoodapp.room.Veritabani
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class YemeklerDaoRepository(var application: Application) {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()
    var vt:Veritabani

    init {
        vt = Veritabani.veritabaniErisim(application)!!
        yemeklerListesi = MutableLiveData()
    }

    fun yemekleriGetir():MutableLiveData<List<Yemekler>> {
        return yemeklerListesi
    }

    fun tumYemekleriAl() {

        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            yemeklerListesi.value = vt.yemeklerDao().tumYemekler()
        }

    }
}