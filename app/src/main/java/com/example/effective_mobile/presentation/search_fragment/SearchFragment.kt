package com.example.effective_mobile.presentation.search_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.effective_mobile.CyrillicInputFilter
import com.example.effective_mobile.R
import com.example.effective_mobile.app.App
import com.example.effective_mobile.databinding.FragmentSearchBinding
import com.example.effective_mobile.presentation.main_fragment.uistate.MainNavigationEvent
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

        childFragmentManager.addOnBackStackChangedListener {

        }

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

        inputFilters()

        inputActionListener()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collect { uiState ->
                binding.editTextFrom.setText(uiState.inputFrom)
                handleNavigationEvent(uiState.navigation, uiState.inputTo)
            }
        }

        binding.editTextTo.requestFocus()

        binding.clearIV.setOnClickListener {
            binding.editTextTo.text?.clear()
        }

//        binding.istanbul.setOnClickListener {
//            navigateToFragmentCountrySelected()
//        }
    }

    private fun handleNavigationEvent(navigation: MainNavigationEvent, argInputTo: String) {
        when (navigation) {

            is MainNavigationEvent.ToFragmentCountrySelected -> {
                findNavController().navigate(
                    SearchFragmentDirections.actionSearchFragmentToCountrySelectedFragment(
                        argInputTo
                    )
                )
                resetNavigation()
            }

            else -> {}
        }
    }

    private fun inputActionListener() {
        binding.editTextTo.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                saveInputToInState()
                navigateToFragmentCountrySelected()
                true
            } else {
                false
            }
        }
    }

    private fun saveInputToInState() {
        viewModel.setInputToInState(binding.editTextTo.text.toString())
    }

    private fun navigateToFragmentCountrySelected() {
        viewModel.navigateToFragmentCountrySelected(MainNavigationEvent.ToFragmentCountrySelected)
    }

    private fun resetNavigation() {
        viewModel.navigateToFragmentMain(MainNavigationEvent.NoNavigation)
    }

    private fun inputFilters() {
        binding.editTextFrom.filters = arrayOf(CyrillicInputFilter())
        binding.editTextTo.filters = arrayOf(CyrillicInputFilter())
    }

    override fun onResume() {
        resetNavigation()
        super.onResume()
    }
}