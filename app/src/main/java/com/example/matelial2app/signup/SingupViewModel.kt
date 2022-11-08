package com.example.matelial2app.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.matelial2app.models.User
import com.example.matelial2app.models.UserKeys

class SingupViewModel : ViewModel(){

    private val _accessKey = MutableLiveData<String>()
    val accessKey: LiveData<String> = _accessKey

    private val _refreshKey = MutableLiveData<String>()
    val refreshKey: LiveData<String> = _refreshKey

    fun setKeys(keys:UserKeys){
        _accessKey.value=keys.accessKey
        _refreshKey.value=keys.refreshKey
    }
}