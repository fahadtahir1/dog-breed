package com.arbisoft.dogbreedsearch.utils.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arbisoft.dogbreedsearch.managers.DataManager
import java.lang.ref.WeakReference

open class BaseViewModel<N>(val dataManager: DataManager) : ViewModel() {
    val isLoading = MutableLiveData(false)

    private var navigator: WeakReference<N>? = null

    open fun getNavigator(): N? {
        return navigator?.get()
    }

    open fun setNavigator(navigator: N) {
        this.navigator = WeakReference(navigator)
    }
}