package com.example.shopapptestproject.models

import com.google.gson.annotations.SerializedName

data class AnswerBot(
    @SerializedName("answer") val answer: String,
    @SerializedName("prompt_tokens") val promptTokens: String,
    @SerializedName("completion_tokens") val completionTokens: String,
    @SerializedName("total_tokens") val totalTokens: String

)
