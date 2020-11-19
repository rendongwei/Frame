package com.don.frame.rxjava.scheduler

object SchedulerUtils {

    fun <T> ioToMain(): IoMainScheduler<T> {
        return IoMainScheduler()
    }

    fun <T> computationToMain(): ComputationMainScheduler<T> {
        return ComputationMainScheduler()
    }

    fun <T> newThreadToMain(): NewThreadMainScheduler<T> {
        return NewThreadMainScheduler()
    }

    fun <T> SingleToMain(): SingleMainScheduler<T> {
        return SingleMainScheduler()
    }

    fun <T> TrampolineToMain(): TrampolineMainScheduler<T> {
        return TrampolineMainScheduler()
    }
}
