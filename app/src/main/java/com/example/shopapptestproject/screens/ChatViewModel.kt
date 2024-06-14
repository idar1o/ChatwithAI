package com.example.shopapptestproject.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopapptestproject.ApiServices.ApiClient
import com.example.shopapptestproject.models.AnswerBot
import com.example.shopapptestproject.models.ChatRequest
import com.example.shopapptestproject.models.Message
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatViewModel : ViewModel() {


    private val _messages = MutableLiveData<List<Message>>()
    val messages: LiveData<List<Message>> get() = _messages
    init {
        _messages.value = mutableListOf()
    }
    fun messageList(text: Message){

        val currentList = _messages.value ?: mutableListOf()
        val updatedList = currentList.toMutableList()
        val call = ApiClient.apiService.getCompletion(ChatRequest( text.message))
        call.enqueue(object : Callback<AnswerBot> {
            override fun onResponse(call: Call<AnswerBot>, response: Response<AnswerBot>) {
                if (response.isSuccessful) {
                    val chatResponse = response.body()
                    chatResponse?.let {
                        val responseMessage = Message(message = it.answer, Message.SENT_BY_BOT )
                        updatedList.add(Message(text.message, Message.SENT_BY_ME))
                        updatedList.add(responseMessage)
                    }
                } else {
                    Log.d("Lol","Request error with code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<AnswerBot>, t: Throwable) {
                Log.d("Lol","Request failed with code: ${t.message}")

            }
        })

        _messages.value = updatedList
    }




}