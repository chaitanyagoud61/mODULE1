package com.example.module.Network_controller;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Network_check {

    public ConnectivityManager connectivityManager;
    public Context context;
    public Network_response networkResponse;

    public Network_check(ConnectivityManager connectivityManager, Context context, Network_response networkResponse) {
        this.connectivityManager = connectivityManager;
        this.context = context;
        this.networkResponse = networkResponse;
    }


    public void check_network(){

        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED){

            networkResponse.Network_response_interface(true);
        }else {
            networkResponse.Network_response_interface(false);
        }
    }
}
