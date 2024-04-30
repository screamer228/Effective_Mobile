package com.example.effective_mobile.presentation.search_fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.effective_mobile.R
import com.example.effective_mobile.app.App
import com.example.effective_mobile.databinding.FragmentSearchBinding
import com.example.effective_mobile.presentation.main_fragment.viewmodel.MainSharedViewModel
import com.example.effective_mobile.presentation.main_fragment.viewmodel.MainSharedViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchFragment : Fragment() {

    private lateinit var _binding: FragmentSearchBinding
    private val binding get() = _binding

    @Inject
    lateinit var viewModelFactory: MainSharedViewModelFactory
    private lateinit var viewModel: MainSharedViewModel
    private var isFragmentCreated = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSearchBinding.inflate(layoutInflater)
        val view = binding.root

        //анимация при переходе
        if (!isFragmentCreated) {
            view.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_up).apply {
                duration = 200
            })
            isFragmentCreated = true
        }

        (requireActivity().applicationContext as App).appComponent.injectSearchFragment(this)
        viewModel =
            ViewModelProvider(requireActivity(), viewModelFactory)[MainSharedViewModel::class.java]

        return view
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

        binding.istanbul.setOnClickListener {
            findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToCountrySelectedFragment())

        }

//    override fun onStop() {
//        super.onStop()
//        val animation = AnimationUtils.loadAnimation(context, R.anim.slide_down).apply {
//            duration = 400 // Установка продолжительности анимации
//        }
//        animation.setAnimationListener(object : Animation.AnimationListener {
//            override fun onAnimationStart(animation: Animation?) {
//                // Анимация началась
//            }
//
//            override fun onAnimationEnd(animation: Animation?) {
//                // Анимация завершилась, вызываем onStop
//                super@SearchFragment.onStop()
//            }
//
//            override fun onAnimationRepeat(animation: Animation?) {
//                // Анимация повторяется
//            }
//        })
//        binding.root.startAnimation(animation)
//    }
    }
}