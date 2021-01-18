package com.jinrongwealth.duriantree.bean

import java.io.Serializable

data class UserBean(
    var id: Int? = 0,
    var nickName: String? = null
) : Serializable