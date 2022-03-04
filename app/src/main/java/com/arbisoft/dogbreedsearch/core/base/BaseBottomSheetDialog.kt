package com.arbisoft.dogbreedsearch.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


abstract class BaseBottomSheetDialog<VB: ViewDataBinding> : BottomSheetDialogFragment() {

    private var _binding:VB? = null

    val binding: VB
    get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater,layout,parent,false)
        return _binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    abstract val layout : Int
}