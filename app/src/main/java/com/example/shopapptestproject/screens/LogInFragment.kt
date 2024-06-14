package com.example.shopapptestproject.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.shopapptestproject.R
import com.example.shopapptestproject.databinding.FragmentChatBinding
import com.example.shopapptestproject.databinding.FragmentLogInBinding

class LogInFragment : Fragment() {

    companion object {
        fun newInstance() = LogInFragment()
    }
    private var _binding: FragmentLogInBinding? = null
    private val viewModel: LoginViewModel by viewModels()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLogInBinding.inflate(inflater)
        // Inflate the layout for this fragment


        return binding.root
    }


}