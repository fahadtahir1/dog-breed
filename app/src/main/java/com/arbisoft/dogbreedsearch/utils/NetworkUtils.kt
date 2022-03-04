package com.arbisoft.dogbreedsearch.utils

import android.content.Context
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object NetworkUtils {
    fun isNetworkConnected(context: Context?): Boolean {
        var result = false
        context?.let {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val activeNetwork = connectivityManager.activeNetwork ?: return false
            val activeNetworkCapabilities =
                connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false

            result = when {
                activeNetworkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetworkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                activeNetworkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }
        return result
    }

    //Check if GPS is enable or not
    fun checkIfGpsEnabled(context: Context?): Boolean {
        val locationManager = context?.getSystemService(Context.LOCATION_SERVICE) as LocationManager?

        locationManager?.let {
            return it.isProviderEnabled(LocationManager.GPS_PROVIDER)
        }
        return false
    }
}