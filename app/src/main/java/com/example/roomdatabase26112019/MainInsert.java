package com.example.roomdatabase26112019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainInsert extends AppCompatActivity {
    Toolbar toolbarMainInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insert);

        toolbarMainInsert = findViewById(R.id.toolbar_insert);
        setActionBar(toolbarMainInsert);
        getActionBar().setTitle("Insert");
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        toolbarMainInsert.setBackgroundColor(Color.BLUE);

        toolbarMainInsert.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainInsert.this,"Nut Back",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainInsert.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }
}
