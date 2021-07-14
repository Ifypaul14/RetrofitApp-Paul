package com.paulo.retrofitapp.ui

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paulo.retrofitapp.api.RetrofitProvider
import com.paulo.retrofitapp.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel () {

    val usersLiveData = MutableLiveData<List<User>>()

    fun getUsers(){
        CoroutineScope(Dispatchers.IO).launch {
            usersLiveData.postValue(RetrofitProvider.placeHolderAPI.getUsers())
        }


    }
}