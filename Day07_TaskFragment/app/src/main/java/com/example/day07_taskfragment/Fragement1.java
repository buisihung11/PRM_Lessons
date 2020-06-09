package com.example.day07_taskfragment;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragement1 extends Fragment {

    private TextView txtResult;
    public static Fragement1 newInstance() {
        return new Fragement1();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement1_fragment, container, false);
        // agrument tu activity truyen qua
        Bundle bundle = this.getArguments();
        txtResult = view.findViewById(R.id.txtResult);
        if(bundle.getString("result") != null){
            txtResult.setText("Result: " + bundle.getString("result"));
        }else{
            txtResult.setText("Result = " + bundle.getString("default"));
        }
        return view;
    }



}
