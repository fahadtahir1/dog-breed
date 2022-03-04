package com.arbisoft.dogbreedsearch.utils.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.arbisoft.dogbreedsearch.R
import com.arbisoft.dogbreedsearch.interfaces.BaseNavigator

abstract class BaseFragment<VM : ViewModel, VB : ViewDataBinding>(@LayoutRes private val layoutResId: Int) :
    Fragment(), BaseNavigator {
    protected abstract val viewModel: VM
    protected lateinit var bindings: VB
    private lateinit var progressBar: Dialog
    protected var baseActivity: BaseActivity<*, *>? = null
    protected abstract fun getBindingVariable(): Int

    open fun initUi() {}

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is BaseActivity<*, *>)
            baseActivity = context

    }

    override fun onDetach() {
        super.onDetach()
        baseActivity = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        bindings = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        bindings.lifecycleOwner = this
        bindings.setVariable(getBindingVariable(), viewModel)
        return bindings.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    override fun showSuccessMessage(successMessage: String?) {
        baseActivity?.showSuccessMessage(successMessage)
    }

    override fun showErrorMessage(error: String?) {
        baseActivity?.showErrorMessage(error)
    }

    override fun goBack() {
        baseActivity?.goBack()
    }


    override fun showProgressBar() {
        if (this::progressBar.isInitialized) {

            if (!progressBar.isShowing) {
                progressBar.show()
            }

        } else {
            baseActivity?.let {
                progressBar = Dialog(it, R.style.TransparentDialog)
                progressBar.apply {
                    setContentView(R.layout.dialog_progress)
                    window?.setLayout(
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.MATCH_PARENT
                    )
                    setCancelable(false)
                    create()
                }.show()
            }
        }
    }

    override fun hideProgressBar() {
        if (this::progressBar.isInitialized) {
            if (progressBar.isShowing) {
                progressBar.dismiss()
            }
        }

    }

    override fun isProgressBarShowing(): Boolean {
        return baseActivity?.isProgressBarShowing() ?: false
    }


}