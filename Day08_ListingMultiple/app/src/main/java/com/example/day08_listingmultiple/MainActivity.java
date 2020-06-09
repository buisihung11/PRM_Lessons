package com.example.day08_listingmultiple;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickToSingleList(View view) {
        Intent intent = new Intent(this, SingleListActivity.class);
        startActivity(intent);
    }

    public void clickToMultipleList(View view) {
        Intent intent = new Intent(this, MultipleListActivity.class);
        startActivity(intent);
    }

    public void clickToMultipleList2(View view) {
        Intent intent = new Intent(this, MultipleListActivity2.class);
        startActivity(intent);

    }
}
