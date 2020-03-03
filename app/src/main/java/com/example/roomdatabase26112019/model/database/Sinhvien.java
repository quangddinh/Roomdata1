package com.example.roomdatabase26112019.model.database;

import android.content.Intent;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.roomdatabase26112019.R;

import java.util.ArrayList;

@Entity(tableName = "sinhvien")
public class Sinhvien {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private String ten;
    private String namsinh;
    private String diachi;

    public Sinhvien() {
    }

    @Ignore
    public Sinhvien(String ten, String namsinh, String diachi) {
        this.ten = ten;
        this.namsinh = namsinh;
        this.diachi = diachi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
