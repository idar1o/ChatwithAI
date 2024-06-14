package com.example.shopapptestproject.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopapptestproject.ApiServices.PaymentClient
import com.example.shopapptestproject.ApiServices.PaymentService
import com.example.shopapptestproject.models.Message
import com.example.shopapptestproject.models.PaymentResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PaymentViewModel : ViewModel() {
    private val answer = MutableLiveData<String>()
    val messages: LiveData<String> get() = answer

    fun payment(){
        val api = PaymentClient.paymentService
        val call = api.createPaymentMethod(
            type = "card",
            cardNumber = "4242424242424242",
            expMonth = 8,
            expYear = 2026,
            cvc = "314"
        )

        call.enqueue(object : Callback<PaymentResponse> {
            override fun onResponse(
                call: Call<PaymentResponse>,
                response: Response<PaymentResponse>
            ) {
                if (response.isSuccessful) {
                    // Handle successful response
                    val paymentMethod = response.body()
                    Log.d("Lol","Payment Method ID: ${paymentMethod?.message}")
                    answer.value = paymentMethod?.message
                } else {
                    // Handle error response
                    Log.d("Lol","Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<PaymentResponse>, t: Throwable) {
                // Handle failure
                Log.d("Lol","Failure: ${t.message}")
            }
        })
    }
}