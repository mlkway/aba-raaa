package com.raywenderlich.workingforshemajamebeli5.ui

import android.util.Log.d
import android.util.Log.i
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raywenderlich.workingforshemajamebeli5.PersonSubListItem
import com.raywenderlich.workingforshemajamebeli5.network.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ScreenViewModel : ViewModel() {

    private val _personData = MutableLiveData<List<List<PersonSubListItem>>>()

    val personData: MutableLiveData<List<List<PersonSubListItem>>> get() = _personData




    init {
        load()
    }



    private fun load(){

        viewModelScope.launch {

            withContext(Dispatchers.Main){

                val data =  Network.gsonService.getPerson()

                _personData.postValue(data.body())

            }



        }


    }

}