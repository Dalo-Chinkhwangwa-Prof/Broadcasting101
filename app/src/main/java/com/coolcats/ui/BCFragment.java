package com.coolcats.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.coolcats.mybroadcastor.databinding.BcFragmentLayoutBinding;

public class BCFragment extends Fragment {


    private BcFragmentLayoutBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = BcFragmentLayoutBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.sendBcButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.radioFrequency);
            intent.putExtra(MainActivity.KEY, "Happy New Month!");
            requireContext().sendBroadcast(intent);
        });
    }
}
