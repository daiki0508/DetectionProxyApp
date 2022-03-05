package com.websarva.wings.android.detectionproxyapp.model

data class Result(
    var success: Boolean,
    var data: Data
)

data class Data(
    var users: Users
)

data class Users(
    var id: String,
    var mail: String,
    var message: String
)
