package com.arbisoft.dogbreedsearch.interfaces

interface BaseNavigator {
    fun goBack()
    fun showSuccessMessage(successMessage: String?)
    fun showErrorMessage(error: String?)

    fun isNetworkConnected(): Boolean {
        return false
    }

    fun showProgressBar()

    fun hideProgressBar()

    fun isProgressBarShowing(): Boolean
}