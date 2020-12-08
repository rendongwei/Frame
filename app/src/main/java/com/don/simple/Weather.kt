package com.don.simple

import java.io.Serializable

data class Weather(
    var code: String,
    var status: Int,
    var msg: String,
    var success: Boolean,
    var data: Any
) : Serializable