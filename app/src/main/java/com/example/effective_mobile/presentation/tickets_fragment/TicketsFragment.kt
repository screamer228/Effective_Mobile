package com.example.effective_mobile.presentation.tickets_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.effective_mobile.app.App
import com.example.effective_mobile.databinding.FragmentTicketsBinding
import com.example.effective_mobile.presentation.tickets_fragment.adapter.TicketsAdapter
import com.example.effective_mobile.presentation.tickets_fragment.uistate.TicketsNavigationEvent
import com.example.effective_mobile.presentation.tickets_fragment.viewmodel.TicketsViewModel
import com.example.effective_mobile.presentation.tickets_fragment.viewmodel.TicketsViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class TicketsFragment : Fragment() {

    private val args: TicketsFragmentArgs by navArgs()
    private lateinit var _binding: FragmentTicketsBinding
    private val binding get() = _binding

    @Inject
    lateinit var viewModelFactory: TicketsViewModelFactory
    private lateinit var viewModel: TicketsViewModel
    private lateinit var adapter: TicketsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity().applicationContext as App).appComponent.injectTicketsFragment(this)
        viewModel =
            ViewModelProvider(this, viewModelFactory)[TicketsViewModel::class.java]

        _binding = FragmentTicketsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setTitles(args.townsTitle, args.dateTitle)

        adapter = TicketsAdapter(requireContext())
        binding.recyclerViewTickets.adapter = adapter

        clickListeners()

        observers()
    }

    private fun observers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collect { uiState ->
                binding.townsTitle.text = uiState.townsTitle
                binding.dateTitle.text = uiState.dateTitle
                adapter.updateList(uiState.ticketsList)
                handleNavigationEvent(uiState.navigation)
            }
        }
    }

    private fun clickListeners() {
        binding.buttonBack.setOnClickListener {
            navigateBack()
        }
    }

    private fun handleNavigationEvent(navigation: TicketsNavigationEvent) {
        when (navigation) {

            is TicketsNavigationEvent.NavigateBack -> {
                findNavController().popBackStack()
                resetNavigation()
            }

            else -> {}
        }
    }

    private fun navigateBack() {
        viewModel.setNavigationState(TicketsNavigationEvent.NavigateBack)
    }

    private fun resetNavigation() {
        viewModel.setNavigationState(TicketsNavigationEvent.NoNavigation)
    }
}