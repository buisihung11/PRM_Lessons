package com.example.day08_listingmultiple;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MultipleListActivity2 extends AppCompatActivity {
    private String[] listSubject;
    private List<String> listChoice;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_list2);
        listView = findViewById(R.id.listSubject);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listSubject = getResources().getStringArray(R.array.listSubject);
        listView.setTextFilterEnabled(true);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, listSubject);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listChoice = new ArrayList<>();
                for (int i = 0; i < parent.getCount(); i++) {
                    boolean check = listView.getCheckedItemPositions().get(i);
                    if (check) {
                        String subjectName = parent.getAdapter().getItem(i).toString();
                        Toast.makeText(MultipleListActivity2.this, "Selected: " + subjectName, Toast.LENGTH_LONG).show();
                        listChoice.add(subjectName);
                    }

                }
            }
        });
    }


    public void clickToSave(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        String result = "";
        for (int i = 0; i < listChoice.size(); i++) {
            result += listChoice.get(i) + " ";
        }
        intent.putExtra("test", result);
        startActivity(intent);
    }
}
