package com.arbisoft.dogbreedsearch.ui.breeds

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.arbisoft.dogbreedsearch.BR
import com.arbisoft.dogbreedsearch.R
import com.arbisoft.dogbreedsearch.utils.base.BaseFragment
import com.arbisoft.dogbreedsearch.databinding.FragmentBreedsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreedFragment : BaseFragment<BreedsViewModel,FragmentBreedsBinding>(R.layout.fragment_breeds) {

    override val viewModel : BreedsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchBreeds()

        bindings.laySelection.setOnClickListener { findNavController().navigate(R.id.action_nav_breed_to_nav_search_breed) }
    }

    override fun getBindingVariable() = BR._all
}