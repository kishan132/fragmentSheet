package me.kishankumar.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class SharedViewModel : ViewModel() {

    private val sharedData: MutableLiveData<Int> = MutableLiveData<Int>()

    fun getSharedData(): LiveData<Int> {
        return sharedData
    }

    fun updateData(newData: Int) {
        sharedData.value = newData
    }
    

}