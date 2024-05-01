package com.example.effective_mobile.presentation.main_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.effective_mobile.utils.CyrillicInputFilter
import com.example.effective_mobile.app.App
import com.example.effective_mobile.databinding.FragmentMainBinding
import com.example.effective_mobile.host.HostActivity
import com.example.effective_mobile.presentation.main_fragment.adapter.OffersAdapter
import com.example.effective_mobile.presentation.main_fragment.uistate.MainNavigationEvent
import com.example.effective_mobile.presentation.main_fragment.viewmodel.MainSharedViewModel
import com.example.effective_mobile.presentation.main_fragment.viewmodel.MainSharedViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragment : Fragment() {

    private lateinit var _binding: FragmentMainBinding
    private val binding get() = _binding
    private lateinit var adapter: OffersAdapter

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

        (activity as? HostActivity)?.showBottomNavigation()

        _binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = OffersAdapter(requireContext())
        binding.recyclerViewOffers.adapter = adapter

        inputFilters()

        observers()

        focusChangeListeners()
    }

    private fun observers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collect { uiState ->
                setTextToInputFrom(uiState.inputFrom)
                adapter.updateList(uiState.offersList)
                handleNavigationEvent(uiState.navigation)
            }
        }
    }

    private fun focusChangeListeners() {
        binding.editTextFrom.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                saveInputFromInState()
            }
        }

        binding.editTextTo.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                navigateToFragmentSearch()
            }
        }
    }

    private fun handleNavigationEvent(navigation: MainNavigationEvent) {
        when (navigation) {

            is MainNavigationEvent.ToFragmentSearch -> {
                saveInputFromInPrefs()
                findNavController().navigate(
                    MainFragmentDirections.actionMainFragmentToSearchFragment()
                )
                resetNavigation()
            }

            else -> {}
        }
    }

    private fun saveInputFromInPrefs() {
        viewModel.saveInputFromInPrefs()
    }

    private fun saveInputFromInState() {
        viewModel.setInputFromInState(binding.editTextFrom.text.toString())
    }

    private fun setTextToInputFrom(inputFrom: String) {
        binding.editTextFrom.setText(inputFrom)
    }

    private fun navigateToFragmentSearch() {
        viewModel.setNavigationState(MainNavigationEvent.ToFragmentSearch)
    }

    private fun resetNavigation() {
        viewModel.setNavigationState(MainNavigationEvent.NoNavigation)
    }

    private fun inputFilters() {
        binding.editTextFrom.filters = arrayOf(CyrillicInputFilter())
        binding.editTextTo.filters = arrayOf(CyrillicInputFilter())
    }
}