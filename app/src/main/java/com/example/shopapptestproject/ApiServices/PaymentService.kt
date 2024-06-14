package com.example.shopapptestproject.ApiServices

import com.example.shopapptestproject.models.AnswerBot
import com.example.shopapptestproject.models.ChatRequest
import com.example.shopapptestproject.models.PaymentResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface PaymentService {
    @FormUrlEncoded
    @POST("v1/payment_methods")
    @Headers("Authorization: Bearer pk_test_51PMjzgFTaGTE6kKRSHUsG1VhLY6CxsopUhcp2OssUtKcwM3yEX450t9tyJby6PEzgIJNKDjpS3HFeRYvgWjCkNfP004XX6SJGw")
    fun createPaymentMethod(
        @Field("type") type: String,
        @Field("card[number]") cardNumber: String,
        @Field("card[exp_month]") expMonth: Int,
        @Field("card[exp_year]") expYear: Int,
        @Field("card[cvc]") cvc: String
    ): Call<PaymentResponse>
}

object PaymentClient {
    private const val BASE_URL = "https://api.stripe.com/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val paymentService: PaymentService by lazy {
        retrofit.create(PaymentService::class.java)
    }
}