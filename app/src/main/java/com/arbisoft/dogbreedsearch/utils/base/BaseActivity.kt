package com.arbisoft.dogbreedsearch.utils.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.arbisoft.dogbreedsearch.R
import com.arbisoft.dogbreedsearch.interfaces.BaseNavigator
import com.arbisoft.dogbreedsearch.utils.showShortToast

abstract class BaseActivity<VM : BaseViewModel<*>, VB : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int,
) : AppCompatActivity(), BaseNavigator {
    protected abstract val viewModel: VM
    protected lateinit var bindings: VB
    protected lateinit var context: Context
    protected lateinit var progressBar: Dialog

    protected abstract fun getBindingVariable(): Int

    open fun initUi() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_DogBreedSearch)
        context = this
        bindings = DataBindingUtil.setContentView(this, layoutResId)
        bindings.setVariable(getBindingVariable(), viewModel)
        bindings.lifecycleOwner = this
        initUi()
    }

    override fun goBack() {
        onBackPressed()
    }

    override fun showSuccessMessage(successMessage: String?) {
        successMessage?.let {
            if (it.isNotEmpty())
                showShortToast(it)
        }
    }

    override fun showErrorMessage(error: String?) {
        if (error != null) {
            if (error.isNotEmpty())
                showShortToast(error)
        }
    }

    protected open fun onSessionExpired() {
    }

    override fun showProgressBar() {
        if (this::progressBar.isInitialized) {
            if (!progressBar.isShowing) {
                progressBar.show()
            }

        } else {
            progressBar = Dialog(this, R.style.TransparentDialog)
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

    override fun hideProgressBar() {
        if (this::progressBar.isInitialized) {
            if (progressBar.isShowing) {
                progressBar.dismiss()
            }
        }
    }

    override fun isProgressBarShowing(): Boolean {
        if (this::progressBar.isInitialized) {
            return progressBar.isShowing
        }
        return false
    }
}
