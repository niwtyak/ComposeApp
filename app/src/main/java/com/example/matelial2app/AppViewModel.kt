package com.example.matelial2app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.matelial2app.models.User

class AppViewModel : ViewModel(){

    private val _currentUser = MutableLiveData<User>()
    val currentUser:LiveData<User> = _currentUser




}