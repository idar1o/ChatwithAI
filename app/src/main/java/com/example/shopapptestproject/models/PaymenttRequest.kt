package com.example.shopapptestproject.models

import com.google.gson.annotations.SerializedName

data class PaymentRequest(
    @SerializedName("cardholder_name") val cardholderName: String,
    @SerializedName("card_number") val cardNumber: String,
    @SerializedName("expiry_date") val expiryDate: String,
    @SerializedName("cvv") val cvv: String,
    @SerializedName("amount") val amount: Double
)

data class PaymentResponse(
    @SerializedName("status") val status: String,
    @SerializedName("transaction_id") val transactionId: String,
    @SerializedName("message") val message: String
)