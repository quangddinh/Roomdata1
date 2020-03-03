package com.example.roomdatabase26112019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainInsert extends AppCompatActivity {
    Toolbar toolbarMainInsert;
    Button mBtnInsert,mBtnDelete;
    EditText mEdtTen,mEdtNamsinh,mEdtDiachi;

    public static final String NAME = "NAME";
    public static final String YEAR = "YEAR";
    public static final String HOME = "HOME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insert);

        init();
        backclick();
        insertclick();
        deleteclick();
    }

    private void deleteclick() {
        mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEdtTen.setText("");
                mEdtDiachi.setText("");
                mEdtNamsinh.setText("");
            }
        });
    }

    private void insertclick() {
        mBtnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = mEdtTen.getText().toString();
                String diachi = mEdtDiachi.getText().toString();
                String namsinh = mEdtNamsinh.getText().toString();
                if(name.equals("") || diachi.equals("") || namsinh.equals("") )
                {
                    Toast.makeText(MainInsert.this , "Bạn Chưa Nhập Thông Tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    Intent intent = new Intent();
                    intent.putExtra(NAME, name);
                    intent.putExtra(YEAR, namsinh);
                    intent.putExtra(HOME, diachi);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

    private void backclick() {
        toolbarMainInsert.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainInsert.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init(){
        mBtnInsert = findViewById(R.id.btn_insert);
        mEdtTen = findViewById(R.id.edt_name);
        mEdtDiachi = findViewById(R.id.edt_address);
        mEdtNamsinh = findViewById(R.id.edt_year);
        mBtnDelete = findViewById(R.id.btn_delete);

        toolbarMainInsert = findViewById(R.id.toolbar_insert);
        setActionBar(toolbarMainInsert);
        getActionBar().setTitle("Insert");
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        toolbarMainInsert.setBackgroundColor(Color.BLUE);
    }
}
