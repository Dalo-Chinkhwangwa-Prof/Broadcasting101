package com.coolcats.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

import com.coolcats.mybroadcastor.R;
import com.coolcats.mybroadcastor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final String radioFrequency = "101.1FM";
    public static final String KEY = "KEY";

    private ActivityMainBinding binding;
    private BroadcastReceiver customReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(radioFrequency)){
                binding.infoTextview.setText(intent.getStringExtra(KEY));
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

    }

    @Override
    protected void onStart() {
        super.onStart();
        //turn radio ON
        registerReceiver(customReceiver, new IntentFilter(radioFrequency));
    }

    @Override
    protected void onStop() {
        super.onStop();
        //turn radio off
        unregisterReceiver(customReceiver);
    }
}