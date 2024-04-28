package com.example.effective_mobile.presentation.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.effective_mobile.CyrillicInputFilter
import com.example.effective_mobile.app.App
import com.example.effective_mobile.databinding.FragmentMainBinding
import com.example.effective_mobile.presentation.main.adapter.OffersAdapter
import com.example.effective_mobile.presentation.main.uistate.MainNavigationEvent
import com.example.effective_mobile.presentation.main.viewmodel.MainSharedViewModel
import com.example.effective_mobile.presentation.main.viewmodel.MainSharedViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragment : Fragment() {

    private lateinit var _binding: FragmentMainBinding
    private val binding get() = _binding
    private val adapter: OffersAdapter = OffersAdapter()

    @Inject
    lateinit var viewModelFactory: MainSharedViewModelFactory
    private lateinit var viewModel: MainSharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity().applicationContext as App).appComponent.injectMainFragment(this)
        viewModel =
            ViewModelProvider(requireActivity(), viewModelFactory)[MainSharedViewModel::class.java]
        _binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("sharedViewModel check", "main fragment viewModel instance: $viewModel")

        binding.recyclerViewOffers.adapter = adapter

        binding.editTextFrom.filters = arrayOf(CyrillicInputFilter())
        binding.editTextTo.filters = arrayOf(CyrillicInputFilter())

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collect { uiState ->
                adapter.updateList(uiState.offersList)
                when (uiState.navigation) {
                    is MainNavigationEvent.ResetNavigation -> findNavController().navigateUp()

                    is MainNavigationEvent.ToFragmentSearch -> findNavController().navigate(
                        MainFragmentDirections.actionMainFragmentToSearchFragment()
                    )
                }
                Log.d("sharedViewModel check", "main fragment collected")
            }
        }

        binding.editTextFrom.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                viewModel.setEditTextFromValue(s.toString())
                Log.d("sharedViewModel check", "afterTextChanged triggered: $s")
            }
        })

        binding.editTextTo.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                viewModel.navigateToFragmentSearch(MainNavigationEvent.ToFragmentSearch)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.navigateToFragmentMain(MainNavigationEvent.ResetNavigation)
    }
}