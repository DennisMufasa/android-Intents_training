package com.example.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class grid extends AppCompatActivity {

    GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        grid = findViewById(R.id.grid);
        grid.setAdapter(new ImageAdapter(this));
    }
}
