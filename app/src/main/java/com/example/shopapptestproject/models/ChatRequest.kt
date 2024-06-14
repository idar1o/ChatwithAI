package com.example.shopapptestproject.models

import com.google.gson.annotations.SerializedName

data class ChatRequest (
    @SerializedName("text") val text: String
)