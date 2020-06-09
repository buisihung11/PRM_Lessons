package com.example.day07_taskfragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    private List<Fragment> fragmentList = new ArrayList<>();
    private Fragement1 tabFrag1;
    private Fragment2 tabFrag2;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.Tab tab1 = bar.newTab();
        tab1.setText("Test tab 1");
        tab1.setTabListener(this);
        bar.addTab(tab1);
        ActionBar.Tab tab2 = bar.newTab();
        tab2.setText("Test tab 2");
        tab2.setTabListener(this);
        bar.addTab(tab2);
//        bar.selectTab(tab2);

    }

    public void clickToDone(View view) {
        EditText edtRole = findViewById(R.id.edtRole);
        String result = username + " - " + edtRole.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("result", result);
        tabFrag1.setArguments(bundle);
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction ft) {
        if (tab.getPosition() == 0) {
            if (tabFrag1 == null) {
                tabFrag1 = new Fragement1();
                Bundle bundle = new Bundle();
                bundle.putString("default", "HungHCC");
                tabFrag1.setArguments(bundle);
                fragmentList.add(tabFrag1);
            } else {
                tabFrag1 = (Fragement1) fragmentList.get(tab.getPosition());
            }
            ft.replace(android.R.id.content, tabFrag1);
        } else {
            if (tabFrag2 == null) {
                tabFrag2 = new Fragment2();

                fragmentList.add(tabFrag2);
            } else {
                tabFrag2 = (Fragment2) fragmentList.get(tab.getPosition());
            }
            ft.replace(android.R.id.content, tabFrag2);
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction ft) {
        if (tab.getPosition() == 0) {
            EditText edtUsername = findViewById(R.id.edtUsername);
            username = edtUsername.getText().toString();
        }
        ft.remove(fragmentList.get(tab.getPosition()));
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction ft) {

    }
}
