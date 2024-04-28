package com.example.effective_mobile.presentation.countryselected

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.effective_mobile.databinding.FragmentCountrySelectedBinding
import com.example.effective_mobile.presentation.countryselected.adapter.TicketsOffersAdapter
import com.example.effective_mobile.presentation.countryselected.viewmodel.CountrySelectedViewModel

class CountrySelectedFragment : Fragment() {

    private lateinit var _binding: FragmentCountrySelectedBinding
    private val binding get() = _binding
    private val adapter: TicketsOffersAdapter = TicketsOffersAdapter()
    private val viewModel: CountrySelectedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountrySelectedBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewTicketsOffers.adapter = adapter


    }
}