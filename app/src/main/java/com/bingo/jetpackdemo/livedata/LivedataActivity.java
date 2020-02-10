package com.bingo.jetpackdemo.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.bingo.jetpackdemo.R;

public class LivedataActivity extends AppCompatActivity {

    private DemoViewModel demoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livedata);
        demoViewModel = ViewModelProviders.of(this).get(DemoViewModel.class);
        demoViewModel.getMyString().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e("LivedataActivity","on Change:值有变化="+s);
            }
        });
    }
}
