package com.example.effective_mobile.presentation.countryselected_fragment

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.effective_mobile.utils.CyrillicInputFilter
import com.example.effective_mobile.R
import com.example.effective_mobile.app.App
import com.example.effective_mobile.databinding.FragmentCountrySelectedBinding
import com.example.effective_mobile.host.HostActivity
import com.example.effective_mobile.presentation.countryselected_fragment.adapter.TicketsOffersAdapter
import com.example.effective_mobile.presentation.countryselected_fragment.uistate.CountrySelectedNavigationEvent
import com.example.effective_mobile.presentation.countryselected_fragment.viewmodel.CountrySelectedViewModel
import com.example.effective_mobile.presentation.countryselected_fragment.viewmodel.CountrySelectedViewModelFactory
import com.example.effective_mobile.utils.MonthDataSource.getMonthNames
import com.example.effective_mobile.utils.StringsUtils.stringsToRow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
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

        setCurrentDate()

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
                    stringsToRow(uiState.inputFrom, uiState.inputTo, getString(R.string.dash)),
                    stringsToRow(
                        binding.buttonDate.text.toString(),
                        binding.buttonPassengerCount.text.first().toString(),
                        getString(R.string.comma_space)
                    ) + getString(
                        R.string.passenger
                    )
                )
            }
        }
    }

    private fun clickListeners() {
        binding.buttonBack.setOnClickListener {
            navigateBack()
        }

        binding.imageViewSwap.setOnClickListener {
            swapInputs()
        }

        binding.imageViewClear.setOnClickListener {
            binding.editTextTo.text?.clear()
        }

        binding.buttonReturnTicket.setOnClickListener {
            openDatePickerDialog(false)
        }

        binding.buttonDate.setOnClickListener {
            openDatePickerDialog(true)
        }

        binding.buttonSeeAllTickets.setOnClickListener {
            navigateToFragmentTickets()
        }
    }

    private fun swapInputs() {
        val inputFrom = binding.editTextFrom.text.toString()
        val inputTo = binding.editTextTo.text.toString()
        binding.editTextFrom.setText(inputTo)
        binding.editTextTo.setText(inputFrom)
        viewModel.setInputFromInState(inputTo)
        viewModel.setInputToInState(inputFrom)
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

            is CountrySelectedNavigationEvent.NavigateBack -> {
                findNavController().popBackStack()
                resetNavigation()
            }

            else -> {}
        }
    }

    private fun navigateToFragmentTickets() {
        viewModel.setNavigationState(CountrySelectedNavigationEvent.ToFragmentTickets)
    }

    private fun navigateBack() {
        viewModel.setNavigationState(CountrySelectedNavigationEvent.NavigateBack)
    }

    private fun resetNavigation() {
        viewModel.setNavigationState(CountrySelectedNavigationEvent.NoNavigation)
    }

    private fun setCurrentDate() {
        val currentDate = Calendar.getInstance().time
        val formattedDate = formatDate(currentDate)
        binding.buttonDate.text = formattedDate
    }

    private fun formatDate(date: Date): String {
        val dateFormat = SimpleDateFormat(getString(R.string.SimpleDateFormat), Locale.getDefault())
        return dateFormat.format(date)
    }

    private fun openDatePickerDialog(isNeedSetSelectedDate: Boolean) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        fun formatDate(dayOfMonth: Int, month: Int): String {
            val monthNames = getMonthNames(requireContext())
            return "$dayOfMonth ${monthNames[month]}"
        }

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, _, selectedMonth, selectedDayOfMonth ->
                val selectedDate = formatDate(selectedDayOfMonth, selectedMonth)

                if (isNeedSetSelectedDate) {
                    binding.buttonDate.text = selectedDate
                }
            },
            year,
            month,
            dayOfMonth
        )
        datePickerDialog.show()
    }

    private fun inputFilters() {
        binding.editTextFrom.filters = arrayOf(CyrillicInputFilter())
        binding.editTextTo.filters = arrayOf(CyrillicInputFilter())
    }
}