package com.example.roomdatabase26112019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainInsert extends AppCompatActivity {
    Toolbar toolbarMainInsert;
    Button mBtnInsert;
    EditText mEdtTen,mEdtNamsinh,mEdtDiachi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insert);

        mBtnInsert = findViewById(R.id.btn_insert);
        mEdtTen = findViewById(R.id.edt_name);
        mEdtDiachi = findViewById(R.id.edt_address);
        mEdtNamsinh = findViewById(R.id.edt_year);


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


        mBtnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainInsert.this,MainActivity.class);
                String name = mEdtTen.getText().toString();
                String diachi = mEdtDiachi.getText().toString();
//                Integer year  = mEdtNamsinh.
                Intent data = new Intent();
                data.putExtra(Intent.EXTRA_TITLE,name);
                data.putExtra(Intent.EXTRA_TITLE,diachi);
                setResult(RESULT_OK,data);
                finish();
                startActivity(intent);

            }
        });

    }
}
