package com.example.day08_listingmultiple;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SingleListActivity extends ListActivity {
    private String[] listObj = {"PRJ311", "PRM121"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listObj);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(this, "Selected: " + listObj[position], Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("test", listObj[position]);
        startActivity(intent);
    }
}
