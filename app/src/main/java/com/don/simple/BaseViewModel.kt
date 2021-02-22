package com.don.simple

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import com.jinrongwealth.duriantree.bean.HttpBean
import kotlinx.coroutines.*

open class BaseViewModel : ViewModel(), LifecycleObserver {

    private val mViewModelJob = SupervisorJob()
    private val mViewModelScope = CoroutineScope(Dispatchers.Main + mViewModelJob)

    fun launch(
        block: suspend CoroutineScope.() -> HttpBean,
        error: suspend CoroutineScope.() -> Unit = {},
        success: suspend CoroutineScope.(bean: HttpBean) -> Unit = {}
    ): Job {
        return mViewModelScope.launch {
            try {
                var bean: HttpBean? = withContext(Dispatchers.IO) {
                    block()
                }
                if (bean?.success == true) {
                    success(bean!!)
                } else {
                    error()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                error()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        mViewModelScope.cancel()
    }
}