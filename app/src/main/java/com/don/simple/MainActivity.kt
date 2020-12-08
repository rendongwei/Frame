package com.don.simple

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.don.frame.core.base.activity.BaseStatusBarActivity
import com.don.frame.core.base.adapter.ListenerAdapter
import com.don.frame.extend.addItemDecoration
import com.don.frame.extend.initLinearLayoutManager
import com.don.frame.extend.toDip
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : BaseStatusBarActivity() {

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun initListener() {

    }

    override fun init() {
        mLvDisplay.initLinearLayoutManager().addItemDecoration(20.toDip(), 20.toDip(), 20.toDip(), 20.toDip()).adapter =
            ListenerAdapter(
                mContext,
                R.layout.fragment_main,
                mutableListOf("hahaha", "啊实打实的撒的按时撒的阿萨德啊打")
            ) { view, position, t ->
                with(view) {
                    textview.text = t
                }
            }
        var viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ViewM::class.java)
        lifecycle.addObserver(viewModel)
        viewModel.login()
    }
}


class ViewM : ViewModel(), LifecycleObserver {

    fun login() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                var json = JsonObject()
                json.addProperty("phone", "15063080813")
                var user = Http.getInstance().mService.login(json)
                println(user.status)
            }
        }
    }
}