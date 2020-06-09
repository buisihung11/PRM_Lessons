package com.example.day08_picturesandmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnContext = findViewById(R.id.btnContext);
        btnContext.setOnCreateContextMenuListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        createMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return menuChoice(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        createMenu(menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return menuChoice(item);
    }

    public void clickToGallery(View view) {
        Intent intent = new Intent(this, GalleryActivity.class);
        startActivity(intent);
    }

    private void createMenu(Menu menu) {
        MenuItem item = menu.add(0, 0, 0, "Item 1");
        MenuItem item2 = menu.add(0, 0, 0, "Item 2");
        MenuItem item3 = menu.add(0, 0, 0, "Item 3");
    }

    private boolean menuChoice(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                Toast.makeText(this, "Item 1 clicked", Toast.LENGTH_LONG).show();
                return true;
            case 1:
                Toast.makeText(this, "Item 2 clicked", Toast.LENGTH_LONG).show();
                return true;
            case 2:
                Toast.makeText(this, "Item 3 clicked", Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }
}
