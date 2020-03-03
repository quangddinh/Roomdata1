package com.example.roomdatabase26112019.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.roomdatabase26112019.model.database.Sinhvien;
import com.example.roomdatabase26112019.repository.RoomRepository;
import java.util.List;


public class Mainviewmodel extends AndroidViewModel {
    private RoomRepository roomRepository;
    private LiveData<List<Sinhvien>> allSinhVien;

    public Mainviewmodel(@NonNull Application application)
    {
        super(application);
        roomRepository = new RoomRepository(application);
        allSinhVien = roomRepository.getAllSinhVien();
    }
    public void insert(Sinhvien sinhvien)
    {
        roomRepository.insert(sinhvien);
    }

    public void deleteAll ()
    {
        roomRepository.deleteAllSinhVien();
    }

    public LiveData<List<Sinhvien>> getAllSinhVien()
    {
        return allSinhVien;
    }

}
