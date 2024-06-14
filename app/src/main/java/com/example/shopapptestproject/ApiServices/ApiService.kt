package com.example.shopapptestproject.ApiServices
import com.example.shopapptestproject.models.AnswerBot
import com.example.shopapptestproject.models.ChatRequest
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("chat-bot/api/")
    fun getCompletion( @Body body: ChatRequest): Call<AnswerBot>
}

object ApiClient {
    private const val BASE_URL = "https://passport.brisklyminds.com/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
