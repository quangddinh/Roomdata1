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

public class MainUpdate extends AppCompatActivity {
    Toolbar toolbarUpdate;
    public static final String EXTRA_TITLE = "NAME";
    public static final String EXTRA_DESCRIPTION = "YEAR";
    public static final String EXTRA_HOME = "HOME";
    public static final String EXTRA_ID = "ID";
    EditText mEdtname,mEdtyear,mEdtaddress;
    Button mBtnUpdate,mBtnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_update);


        init();
        setlistener();
    }

    private void setlistener() {
        Intent intent = getIntent();
        if(intent.hasExtra(EXTRA_ID))
        {
            mEdtname.setText(intent.getStringExtra(EXTRA_TITLE));
            mEdtyear.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            mEdtaddress.setText(intent.getStringExtra(EXTRA_HOME));
        }

        mBtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten =  mEdtname.getText().toString();
                String namsinh = mEdtyear.getText().toString();
                String diachi = mEdtaddress.getText().toString();

                if(ten.equals("") || namsinh.equals("") || diachi.equals("") )
                {
                    Toast.makeText(MainUpdate.this, "Bạn Chưa Nhập Thông Tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    Intent intent = new Intent();
                    intent.putExtra(EXTRA_TITLE, ten);
                    intent.putExtra(EXTRA_DESCRIPTION, namsinh);
                    intent.putExtra(EXTRA_HOME, diachi);

                    int id = getIntent().getIntExtra(EXTRA_ID, -1);

                    if(id != -1)
                    {
                        intent.putExtra(EXTRA_ID, id);
                    }
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

    }

    private void init() {

        mEdtname = findViewById(R.id.edt_name_update);
        mEdtyear = findViewById(R.id.edt_year_update);
        mEdtaddress = findViewById(R.id.edt_address_update);
        mBtnUpdate = findViewById(R.id.btn_update);
        mBtnDelete  = findViewById(R.id.btn_delete_update);

        toolbarUpdate = findViewById(R.id.toolbar_update);
        setActionBar(toolbarUpdate);
        getActionBar().setTitle("Update");
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        toolbarUpdate.setBackgroundColor(Color.DKGRAY);
        toolbarUpdate.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainUpdate.this, "Back ne", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainUpdate.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
