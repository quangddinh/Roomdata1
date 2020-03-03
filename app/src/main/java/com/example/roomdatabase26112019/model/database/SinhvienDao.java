package com.example.roomdatabase26112019.model.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import io.reactivex.Observable;

@Dao
public interface SinhvienDao {

    @Query("SELECT * FROM sinhvien")
    LiveData<List<Sinhvien>> getAllSinhVien();

    @Insert
    void insert(Sinhvien sinhvien);

    @Update
    void update(Sinhvien sinhvien);

    @Delete
    void delete(Sinhvien sinhvien);

    @Query("DELETE FROM sinhvien")
    void deleteAllSinhvien();

}


