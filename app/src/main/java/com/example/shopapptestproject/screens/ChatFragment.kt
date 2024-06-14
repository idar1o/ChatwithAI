package com.example.shopapptestproject.screens

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapp.MessageAdapter

import com.example.shopapptestproject.databinding.FragmentChatBinding
import com.example.shopapptestproject.models.Message

class ChatFragment : Fragment() {


    companion object {
        fun newInstance() = ChatFragment()
    }

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!
    private val vm: ChatViewModel by viewModels()
    private lateinit var messageAdapter: MessageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatBinding.inflate(layoutInflater)
        // Инициализация адаптера с пустым списком
        messageAdapter = MessageAdapter(emptyList())
        binding.recyclerView.adapter = messageAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context).apply {
            stackFromEnd = true
        }

        // Наблюдаем за изменениями в списке сообщений
        vm.messages.observe(viewLifecycleOwner, Observer { messages ->
            messageAdapter = MessageAdapter(messages)
            binding.recyclerView.adapter = messageAdapter
            binding.recyclerView.scrollToPosition(messages.size - 1)
        })

        // Установка слушателя на кнопку отправки
        binding.sendBtn.setOnClickListener {
            val message = binding.messageEditText.text.toString()
            vm.messageList(Message(message, Message.SENT_BY_ME))

            binding.messageEditText.text.clear()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}