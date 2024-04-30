package com.example.effective_mobile.presentation.countryselected_fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.effective_mobile.app.App
import com.example.effective_mobile.databinding.FragmentCountrySelectedBinding
import com.example.effective_mobile.presentation.countryselected_fragment.adapter.TicketsOffersAdapter
import com.example.effective_mobile.presentation.countryselected_fragment.viewmodel.CountrySelectedViewModel
import com.example.effective_mobile.presentation.countryselected_fragment.viewmodel.CountrySelectedViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class CountrySelectedFragment : Fragment() {

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
        (requireActivity().applicationContext as App).appComponent.injectCountrySelectedFragment(this)
        viewModel =
            ViewModelProvider(this, viewModelFactory)[CountrySelectedViewModel::class.java]

        _binding = FragmentCountrySelectedBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TicketsOffersAdapter(requireContext())
        binding.recyclerViewTicketsOffers.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collect { uiState ->
                Log.d("json check", "in uiState: ${uiState.ticketsOffersList.first().title}")
                adapter.updateList(uiState.ticketsOffersList)
//                when (uiState.navigation) {
//                    is CountrySelectedNavigationEvent.ResetNavigation -> findNavController().navigateUp()
//
//                    is CountrySelectedNavigationEvent.ToFragmentTickets -> findNavController().navigate(
//                        CountrySelectedFragmentDirections.actionMainFragmentToSearchFragment()
//                    )
//                }
            }
        }
    }
}