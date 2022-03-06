package com.websarva.wings.android.detectionproxyapp.model

import androidx.annotation.Keep

@Keep
data class Result(
    var success: Boolean,
    var data: Data
)

@Keep
data class Data(
    var users: Users
)

@Keep
data class Users(
    var id: String,
    var mail: String,
    var message: String
)
