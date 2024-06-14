package com.example.shopapptestproject.screens

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.chatapp.MessageAdapter
import com.example.shopapptestproject.R
import com.example.shopapptestproject.databinding.FragmentLogInBinding
import com.example.shopapptestproject.databinding.FragmentPaymentBinding

class PaymentFragment : Fragment() {

    companion object {
        fun newInstance() = PaymentFragment()
    }

    private var _binding: FragmentPaymentBinding?= null
    private val binding get() = _binding!!
    private val viewModel: PaymentViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPaymentBinding.inflate(inflater)
        viewModel.messages.observe(viewLifecycleOwner, Observer { messages ->
            binding.tvPaymentHeader.text = messages
        })

        binding.btnPay.setOnClickListener{
            viewModel.payment()
        }


        return binding.root
    }
}