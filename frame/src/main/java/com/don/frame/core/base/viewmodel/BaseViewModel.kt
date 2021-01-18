package com.don.frame.core.base.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

open class BaseViewModel : ViewModel(), LifecycleObserver {

    private val mViewModelJob = SupervisorJob()
    private val mViewModelScope = CoroutineScope(Dispatchers.Main + mViewModelJob)

    fun launch(block: suspend CoroutineScope.() -> Unit): Job {
        return mViewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    block()
                }
            } catch (e: Exception) {
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        mViewModelScope.cancel()
    }
}