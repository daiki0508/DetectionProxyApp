package com.websarva.wings.android.detectionproxyapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.websarva.wings.android.detectionproxyapp.repository.HttpConnectRepositoryClient
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val httpConnectRepository: HttpConnectRepositoryClient,
    application: Application
) : AndroidViewModel(application) {
    private val _result = MutableLiveData<Boolean>()
    val result: LiveData<Boolean> = Transformations.map(_result){
        it
    }

    fun connect(){
        httpConnectRepository.connect {
          _result.value = it
        }
    }
}