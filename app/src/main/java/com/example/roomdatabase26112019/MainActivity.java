package com.example.roomdatabase26112019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.roomdatabase26112019.model.database.Sinhvien;
import com.example.roomdatabase26112019.viewmodel.Mainviewmodel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button mBtnUpdate;
    Mainviewmodel mainviewmodel;
    Toolbar toolbarMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainviewmodel = new ViewModelProvider(this).get(Mainviewmodel.class);
        getLifecycle().addObserver(mainviewmodel);
        toolbarMain = findViewById(R.id.toolbar_main);
        setActionBar(toolbarMain);
        getActionBar().setTitle("");
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        toolbarMain.setBackgroundColor(Color.BLUE);

        toolbarMain.inflateMenu(R.menu.menu_main);

        mBtnUpdate = findViewById(R.id.btn_update);

        obserData();
        setListener();
        // tao Btn roi intent sang Update, sau do tao RecycleViwe

    }
    private void setListener() {
//        mainviewmodel.getAllSinhvien(this);
//        mainviewmodel.insertSinhvien(this, new Sinhvien[]{new Sinhvien("Nguyễn Văn A", 1990, "Quận 1")});
        toolbarMain.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Nut back", Toast.LENGTH_SHORT).show();
            }
        });
        toolbarMain.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.item_insert){
                    Intent intent = new Intent(MainActivity.this,MainInsert.class);
                    startActivity(intent);
                    // chuyen sang man hinh insert
                }
                return false;
            }
        });
        mBtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainUpdate.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    private void obserData() {
        mainviewmodel.getAllSinhvienSuccess().observe(this, new Observer<List<Sinhvien>>() {
            @Override
            public void onChanged(List<Sinhvien> sinhviens) {
                Log.d("BBB",sinhviens.toString());
            }
        });
        mainviewmodel.getIdAfterInsertSuccess().observe(this, new Observer<List<Long>>() {
            @Override
            public void onChanged(List<Long> longs) {
                Log.d("BBB",longs.toString());
            }
        });
    }
}
