package com.don.frame.rxjava.scheduler

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TrampolineMainScheduler<T> : BaseScheduler<T>(Schedulers.trampoline(), AndroidSchedulers.mainThread())
