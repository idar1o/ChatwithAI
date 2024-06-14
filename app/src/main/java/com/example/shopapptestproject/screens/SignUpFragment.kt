package com.example.shopapptestproject.screens

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shopapptestproject.R
import com.example.shopapptestproject.databinding.FragmentChatBinding

class SignUpFragment : Fragment() {


    companion object {
        fun newInstance() = SignUpFragment()
    }

    private var _binding: FragmentChatBinding? = null
    private val viewModel: SignUpViewModel by viewModels()
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatBinding.inflate(layoutInflater)



        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}