package com.arbisoft.dogbreedsearch.presentation.breeds

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.arbisoft.dogbreedsearch.R
import com.arbisoft.dogbreedsearch.core.base.BaseFragment
import com.arbisoft.dogbreedsearch.databinding.FragmentBreedsBinding
import com.arbisoft.dogbreedsearch.databinding.ItemMainDogBinding
import com.arbisoft.dogbreedsearch.domain.model.Breed
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class BreedFragment : BaseFragment<FragmentBreedsBinding>() {

    override val layout: Int = R.layout.fragment_breeds

    private val viewModel : BreedsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.laySelection.setOnClickListener { findNavController().navigate(R.id.action_nav_breed_to_nav_search_breed) }

        lifecycleScope.launchWhenCreated {
            viewModel.searchBreedsList.collect{
                if (it.isLoading) {
                    binding.progressBar.isVisible = true
                    binding.tvNotFound.isVisible = false
                }

                if (it.error.isNotBlank()) {
                    binding.progressBar.isVisible = false
                    binding.tvNotFound.isVisible = true
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                }

                it.data?.let { items ->
                    if (items.isEmpty()) {
                        binding.tvNotFound.visibility = View.VISIBLE
                    }
                    binding.progressBar.isVisible = false
                    binding.tvNotFound.isVisible = false

                    initBreedListView(items)
                }
            }
        }
    }

    private fun initBreedListView(items : List<Breed>) {
        binding.rvDogImages.adapter = BreedAdapter().also {
            it.items = items as MutableList<Breed>
            it.listener = { itemMainDogBinding: ItemMainDogBinding, breed: Breed, i: Int ->

            }
        }
    }
}