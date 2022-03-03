package com.arbisoft.dogbreedsearch.presentation.searchbreed

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.arbisoft.dogbreedsearch.R
import com.arbisoft.dogbreedsearch.core.Resource
import com.arbisoft.dogbreedsearch.core.base.BaseBottomSheetDialog
import com.arbisoft.dogbreedsearch.databinding.DialogSearchBreedBinding
import com.arbisoft.dogbreedsearch.presentation.breeds.BreedsViewModel

class SearchBreedsDialog : BaseBottomSheetDialog<DialogSearchBreedBinding>() {

    private val adapter by lazy {   ArrayAdapter(requireContext(),android.R.layout.simple_expandable_list_item_1,
        listOf<String>()) }

    private val viewModel : BreedsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBreedListView()

        lifecycleScope.launchWhenCreated {
            viewModel.searchBreedsList.collect{
                if (it.isLoading){
                    binding.progressBar.isVisible = true
                }

                if (it.error.isNotBlank()){

                }

                it.data?.let {

                }
            }
        }
    }

    private fun initBreedListView() {
        binding.lvDogBreeds.adapter = this.adapter
    }

    override val layout: Int = R.layout.dialog_search_breed
}