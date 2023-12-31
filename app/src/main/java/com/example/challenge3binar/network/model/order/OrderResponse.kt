package com.example.challenge3binar.network.model.order


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class OrderResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: Boolean?
)