package com.bingo.jetpackdemo.lifecycle;

import android.content.IntentFilter;
import android.net.ConnectivityManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

import static java.util.Objects.requireNonNull;

/**
 * ================================
 *
 * @author: zcb
 * @email: zcbin2@grgbanking.com
 * @time: 2020-02-13 11:44
 * @version: 1.0
 * @description: 使用lifecycle 进行网络情况监控
 * =================================
 */
public class NetworkLifecycle implements DefaultLifecycleObserver {
        private static final NetworkLifecycle networkInstance = new NetworkLifecycle();
        private NetworkStateReceive networkStateReceive;
        private MutableLiveData<NetState> netStateLiveData=new MutableLiveData<>();

        public static NetworkLifecycle getInstance(){
                return networkInstance;
        }

        @Override
        public void onCreate(@NonNull LifecycleOwner owner) {
                networkStateReceive = new NetworkStateReceive();
                IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
                if (owner instanceof AppCompatActivity){
                        ((AppCompatActivity)owner).registerReceiver(networkStateReceive,intentFilter);
                }else if (owner instanceof Fragment){
                        ((Fragment)owner).getActivity().registerReceiver(networkStateReceive,intentFilter);
                }
        }

        @Override
        public void onStop(@NonNull LifecycleOwner owner) {
                if (owner instanceof AppCompatActivity) {
                        ((AppCompatActivity) owner).unregisterReceiver(networkStateReceive);
                } else if (owner instanceof Fragment) {
                        requireNonNull(((Fragment) owner).getActivity())
                                .unregisterReceiver(networkStateReceive);
                }
        }
}
