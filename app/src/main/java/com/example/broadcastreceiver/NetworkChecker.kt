package com.example.broadcastreceiver

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

class NetworkChecker(private val context: Context) {
    lateinit var payam : String
    val isInternetConnected: Boolean
    get() {
            var result = false
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)//for android 23<up
            {
                val networkCapabilities = connectivityManager.activeNetwork ?: return false
                val myNetwork =
                    connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

                result = when {
                    myNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        true
                    }//wifi
                    myNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        true
                    }//mobile data
                    myNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true

                    else -> false
                }
            } else //for android 23>less
            {

                result = when (connectivityManager.activeNetworkInfo?.type) {
                    ConnectivityManager.TYPE_WIFI -> true
                    ConnectivityManager.TYPE_MOBILE -> true
                    ConnectivityManager.TYPE_ETHERNET -> true
                    else -> false
                }


            }


            return result
        }
    init
    {
        if (isInternetConnected==true)
        {
            payam = "اینترنت شما وصل است"
        }else{
            payam = "اینترنت شما وصل نیست"
        }
    }


}