package com.sri.voiceofcustomer;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by SRiGorthi on 14-01-2017.
 */

public class ConnectivityUtil extends Application {

    public static int TYPE_NOT_CONNECTED ;

    public static int getConnectivityStatus(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork == null) {
            TYPE_NOT_CONNECTED = 0;
        }
        return TYPE_NOT_CONNECTED;
    }

    public static String getConnectivityStatusString(Context context) {
        int conn = ConnectivityUtil.getConnectivityStatus(context);
        String status = null;
          if (conn == ConnectivityUtil.TYPE_NOT_CONNECTED) {
            status = "Not connected to Internet. Check your network settings and try again.";
        }
        return status;
    }
}
