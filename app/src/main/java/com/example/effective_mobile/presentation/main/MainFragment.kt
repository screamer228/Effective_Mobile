package com.example.effective_mobile.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.effective_mobile.CyrillicInputFilter
import com.example.effective_mobile.databinding.FragmentMainBinding
import com.example.effective_mobile.presentation.main.adapter.OffersAdapter
import com.example.effective_mobile.presentation.main.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private lateinit var _binding: FragmentMainBinding
    private val binding get() = _binding
    private val viewModel: MainViewModel by viewModel()
    private val adapter: OffersAdapter = OffersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewOffers.adapter = adapter

        binding.editTextFrom.filters = arrayOf(CyrillicInputFilter())
        binding.editTextTo.filters = arrayOf(CyrillicInputFilter())

//        val offersRepository : OffersRepository = OffersRepositoryImpl()
//
//        val dataList = offersRepository.getOffers(requireContext())

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collect { resources ->

                Log.d("uiState check", "collect triggered")
                Log.d("uiState check", viewModel.uiState.value.offersList.first().imageUrl)
                adapter.updateList(resources.offersList)
            }
        }

        binding.button.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToSearchFragment()
            findNavController().navigate(action)
        }
    }
}