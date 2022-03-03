package com.arbisoft.dogbreedsearch.presentation.breeds

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.arbisoft.dogbreedsearch.R
import com.arbisoft.dogbreedsearch.core.base.BaseFragment
import com.arbisoft.dogbreedsearch.databinding.FragmentBreedsBinding

class BreedFragment : BaseFragment<FragmentBreedsBinding>() {

    override val layout: Int = R.layout.fragment_breeds

    private val viewModel : BreedsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.laySelection.setOnClickListener { findNavController().navigate(R.id.action_nav_breed_to_nav_search_breed) }
    }
}