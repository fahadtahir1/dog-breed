package com.arbisoft.dogbreedsearch.ui.searchbreed

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.arbisoft.dogbreedsearch.R
import com.arbisoft.dogbreedsearch.utils.base.BaseBottomSheetDialog
import com.arbisoft.dogbreedsearch.databinding.DialogSearchBreedBinding
import com.arbisoft.dogbreedsearch.ui.breeds.BreedsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchBreedsDialog : BaseBottomSheetDialog<DialogSearchBreedBinding>() {

    private val viewModel: BreedsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchBreeds()

        lifecycleScope.launchWhenCreated {
            viewModel.breedsList.collect {
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
                    val breedNames = items.map { it.name }
                    initBreedListView(breedNames)
                }
            }
        }
    }

    private fun initBreedListView(items: List<String>) {
        val adapter = ArrayAdapter(
            requireContext(), android.R.layout.simple_expandable_list_item_1,
            items
        )

        binding.lvDogBreeds.adapter = adapter
    }

    override val layout: Int = R.layout.dialog_search_breed
}