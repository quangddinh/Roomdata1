package com.example.roomdatabase26112019;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.roomdatabase26112019.model.database.Sinhvien;
import com.example.roomdatabase26112019.viewmodel.Mainviewmodel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button mEdit;
    RecyclerView recycle;
    Mainviewmodel mainviewmodel;
    Toolbar toolbarMain;
    RecyclerView mRv1;
    SinhvienAdapter mSvAdapter;
    int mRequestCodeImage = 123;
    TextView mTvName, mTvYear, mTvAddress,mTvShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
        setListener();
    }

    private void init() {
        mSvAdapter = new SinhvienAdapter();
        mRv1 = findViewById(R.id.rcvSv);
        mRv1.setAdapter(mSvAdapter);

        mEdit = findViewById(R.id.btn_edit);
        mTvName = findViewById(R.id.tv_name);
        mTvAddress = findViewById(R.id.tv_address);
        mTvYear = findViewById(R.id.tv_year);
        mTvShow = findViewById(R.id.tv_show);
        recycle = findViewById(R.id.rcvSv);

        mRv1.setLayoutManager(new LinearLayoutManager(this));
        mRv1.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        recycle.setLayoutManager(mLayoutManager);

        mainviewmodel = ViewModelProviders.of(this).get(Mainviewmodel.class);
        mainviewmodel.getAllSinhVien().observe(this, new Observer<List<Sinhvien>>() {
            @Override
            public void onChanged(List<Sinhvien> sinhviens) {
                mSvAdapter.setSinhviens(sinhviens);
            }
        });

        toolbarMain = findViewById(R.id.toolbar_main);
        setActionBar(toolbarMain);
        getActionBar().setTitle("Quan ly sinh vien");
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarMain.setBackgroundColor(Color.LTGRAY);
        toolbarMain.inflateMenu(R.menu.menu_main);
    }

    private void setListener() {
//        toolbarMain.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Nut back", Toast.LENGTH_SHORT).show();
//            }
//        });
        toolbarMain.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.item_insert){
                    Intent intent = new Intent(MainActivity.this,MainInsert.class);
                    startActivityForResult(intent, mRequestCodeImage);
                    mTvShow.setVisibility(View.GONE);
                } else
                    if (menuItem.getItemId() == R.id.item_deleteAllSinhVien){
                        mainviewmodel.deleteAll();
                        Toast.makeText(MainActivity.this, "Clear data success"
                                , Toast.LENGTH_SHORT).show();
                        mTvShow.setVisibility(View.VISIBLE);
                }
                return false;
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == mRequestCodeImage && resultCode == RESULT_OK && data != null) {

            String name = data.getStringExtra(MainInsert.NAME);
            String yearBirth = data.getStringExtra(MainInsert.YEAR);
            String diachi = data.getStringExtra(MainInsert.HOME);
            Sinhvien sinhvien1 = new Sinhvien(name, yearBirth, diachi);
            mainviewmodel.insert(sinhvien1);

        Toast.makeText(MainActivity.this, "Insert success", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this,"No data",Toast.LENGTH_SHORT).show();
        }
            super.onActivityResult(requestCode, resultCode, data);
    }
}
