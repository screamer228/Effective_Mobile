package com.example.effective_mobile.presentation.countryselected_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.effective_mobile.CyrillicInputFilter
import com.example.effective_mobile.R
import com.example.effective_mobile.app.App
import com.example.effective_mobile.databinding.FragmentCountrySelectedBinding
import com.example.effective_mobile.host.HostActivity
import com.example.effective_mobile.presentation.countryselected_fragment.adapter.TicketsOffersAdapter
import com.example.effective_mobile.presentation.countryselected_fragment.uistate.CountrySelectedNavigationEvent
import com.example.effective_mobile.presentation.countryselected_fragment.viewmodel.CountrySelectedViewModel
import com.example.effective_mobile.presentation.countryselected_fragment.viewmodel.CountrySelectedViewModelFactory
import com.example.effective_mobile.utils.StringsUtils.stringsToRow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CountrySelectedFragment : Fragment() {

    private val args: CountrySelectedFragmentArgs by navArgs()
    private lateinit var _binding: FragmentCountrySelectedBinding
    private val binding get() = _binding
    private lateinit var adapter: TicketsOffersAdapter

    @Inject
    lateinit var viewModelFactory: CountrySelectedViewModelFactory
    private lateinit var viewModel: CountrySelectedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity().applicationContext as App).appComponent.injectCountrySelectedFragment(
            this
        )
        viewModel =
            ViewModelProvider(this, viewModelFactory)[CountrySelectedViewModel::class.java]

        (activity as? HostActivity)?.showBottomNavigation()

        _binding = FragmentCountrySelectedBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setInputToInState(args.inputTo)

        adapter = TicketsOffersAdapter(requireContext())
        binding.recyclerViewTicketsOffers.adapter = adapter

        inputFilters()

        clickListeners()

        observers()

    }

    private fun observers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collect { uiState ->
                binding.editTextFrom.setText(uiState.inputFrom)
                binding.editTextTo.setText(uiState.inputTo)
                adapter.updateList(uiState.ticketsOffersList)
                handleNavigationEvent(
                    uiState.navigation,
                    stringsToRow(uiState.inputFrom, uiState.inputTo, "-"),
                    stringsToRow(
                        binding.dateBtn.text.toString(),
                        binding.countPassBtn.text.first().toString(),
                        ", "
                    ) + getString(
                        R.string.passenger
                    )
                )
            }
        }
    }

    private fun clickListeners() {
        binding.buttonSeeAllTickets.setOnClickListener {
            navigateToFragmentTickets()
        }
    }

    private fun handleNavigationEvent(
        navigation: CountrySelectedNavigationEvent,
        townsTitle: String,
        dateTitle: String
    ) {
        when (navigation) {

            is CountrySelectedNavigationEvent.ToFragmentTickets -> {
                findNavController().navigate(
                    CountrySelectedFragmentDirections.actionCountrySelectedFragmentToTicketsFragment(
                        townsTitle,
                        dateTitle
                    )
                )
                resetNavigation()
            }

            else -> {}
        }
    }

    private fun navigateToFragmentTickets() {
        viewModel.setNavigationState(CountrySelectedNavigationEvent.ToFragmentTickets)
    }

    private fun resetNavigation() {
        viewModel.setNavigationState(CountrySelectedNavigationEvent.NoNavigation)
    }

    private fun inputFilters() {
        binding.editTextFrom.filters = arrayOf(CyrillicInputFilter())
        binding.editTextTo.filters = arrayOf(CyrillicInputFilter())
    }
}