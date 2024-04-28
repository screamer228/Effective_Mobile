package com.example.effective_mobile.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.effective_mobile.app.App
import com.example.effective_mobile.databinding.FragmentSearchBinding
import com.example.effective_mobile.presentation.main.viewmodel.MainSharedViewModel
import com.example.effective_mobile.presentation.main.viewmodel.MainSharedViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchFragment : Fragment() {

    private lateinit var _binding: FragmentSearchBinding
    private val binding get() = _binding

    @Inject
    lateinit var viewModelFactory: MainSharedViewModelFactory
    private lateinit var viewModel: MainSharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity().applicationContext as App).appComponent.injectSearchFragment(this)
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory)[MainSharedViewModel::class.java]
        _binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("sharedViewModel check", "search fragment viewModel instance: $viewModel")


        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collect { uiState ->
                binding.editTextFrom.setText(uiState.inputFrom)
                Log.d("sharedViewModel check", "search fragment collected: ${uiState.inputFrom}")
            }
        }

        binding.editTextTo.requestFocus()

        binding.clearIV.setOnClickListener {
            binding.editTextTo.text?.clear()
        }
    }
}