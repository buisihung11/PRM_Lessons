package com.example.da05_spinner_date;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private TextView txtBirthDay;
    private Spinner spnNationality;
    private String selectedSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtBirthDay = findViewById(R.id.txtBirthDay);
        spnNationality = findViewById(R.id.spnNationality);

        List<String> dataSrc = new ArrayList<>();
        dataSrc.add("Kinh");
        dataSrc.add("It nguoi");
        dataSrc.add("Nuoc ngoai");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,dataSrc);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnNationality.setAdapter(dataAdapter);
        spnNationality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedSpinner = spnNationality.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void clickToRegister(View view) {
        Intent intent = new Intent(this,ShowActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("birthday",txtBirthDay.getText().toString());
        bundle.putString("nationality",selectedSpinner);
        intent.putExtra("INFO",bundle);
        startActivity(intent);
        finish();
    }

    public void clickToGetDate(View view) {
        DialogFragment dateFragment = new DatePickerFragment();
        dateFragment.show(getSupportFragmentManager(),"DatePicker");
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        txtBirthDay.setText(dayOfMonth + " " + month + " " + year);
    }
}
