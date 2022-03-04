package com.arbisoft.dogbreedsearch.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun Context.showShortToast(message: String) {
    Toast.makeText(
        this, message,
        Toast.LENGTH_SHORT
    ).show()
}

fun Context.showLongToast(message: String) {
    Toast.makeText(
        this, message,
        Toast.LENGTH_LONG
    ).show()
}

fun View.showSnackbar(message: String) =
    Snackbar.make(this, message, Snackbar.LENGTH_SHORT).also { snackbar ->
        snackbar.setAction("Okay") { snackbar.dismiss() }
    }.show()