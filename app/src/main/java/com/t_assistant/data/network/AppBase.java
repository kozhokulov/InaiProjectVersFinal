package com.t_assistant.data.network;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.t_assistant.R;
import com.t_assistant.components.About;
import com.t_assistant.components.GridAdapter;
import com.t_assistant.components.SettingsActivity;
import com.t_assistant.database.DatabaseHandler;

import java.util.ArrayList;


public class AppBase extends AppCompatActivity {

    public static ArrayList<String> divisions;
    public static DatabaseHandler handler;
    public static Activity activity;
    ArrayList<String> basicFields;
    GridAdapter adapter;
    GridView gridView;

    public static Fragment getInstance() {
        return new Fragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mai_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout);
        basicFields = new ArrayList<>();
        handler = new DatabaseHandler(this);
        activity = this;

        getSupportActionBar().show();
        divisions = new ArrayList<>();
        divisions.add("AIN-1-20");
        divisions.add("AIN-2-20");
        divisions.add("AIN-3-20");
        divisions.add("WIN-1-20");
        divisions.add("MIN-1-20");
        gridView = (GridView) findViewById(R.id.grid);
        basicFields.add("ПОСЕЩЕНИЕ");
        basicFields.add("РАСПИСАНИЕ");
        basicFields.add("ЗАМЕТКИ");
        basicFields.add("СТУДЕНТЫ");
        basicFields.add("КАЛЬКУЛЯТОР ОЦЕНОК");
        adapter = new GridAdapter(this, basicFields);
        gridView.setAdapter(adapter);
    }

    public void loadSettings(MenuItem item) {
        Intent launchIntent = new Intent(this, SettingsActivity.class);
        startActivity(launchIntent);
    }

    public void loadAbout(MenuItem item) {
        Intent launchIntent = new Intent(this, About.class);
        startActivity(launchIntent);
    }

    public void loadExit(MenuItem item) {
        finish();
        System.exit(0);
    }
}