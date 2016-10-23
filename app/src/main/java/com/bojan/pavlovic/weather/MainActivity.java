package com.bojan.pavlovic.weather;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!checkInternetConnection())
           Toast.makeText(this, "Not Connected to internet", Toast.LENGTH_LONG).show();

        
    }

    // Weather app needs internet connection to work.
    // If device is not connected to internet ask user to connect.
    // TODO Implement ping to some address to check if internet available. Show Settings box to user and offer him to connect if not connected.
    private boolean checkInternetConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isAvailable() &&
                connectivityManager.getActiveNetworkInfo().isConnected()){
            return true;
        }
        return false;
    }
}
