package com.don.simple

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    flow {
        for (i in 0..3) {
            emit(i)
        }
    }.onStart {
        println("开始了")
    }.onCompletion {
        println("完成了")
    }.collect {
        println(it)
    }
}