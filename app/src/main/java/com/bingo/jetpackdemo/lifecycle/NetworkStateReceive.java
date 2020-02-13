package com.bingo.jetpackdemo.lifecycle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import com.bingo.jetpackdemo.R;
import com.bingo.jetpackdemo.utils.NetworkUtils;

import java.util.Objects;

/**
 * ================================
 *
 * @author: zcb
 * @email: zcbin2@grgbanking.com
 * @time: 2020-02-13 11:57
 * @version: 1.0
 * @description:
 * =================================
 */
public class NetworkStateReceive extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Objects.equals(intent.getAction(), ConnectivityManager.CONNECTIVITY_ACTION)) {
            boolean connect = NetworkUtils.isConnected();
            if (!connect) {
                //断网啦
                Toast.makeText(context,
                        context.getString(R.string.network_disconnected), Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }
}
