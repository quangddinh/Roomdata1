package com.example.roomdatabase26112019.repository;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.example.roomdatabase26112019.model.database.Sinhvien;
import com.example.roomdatabase26112019.model.database.SinhvienDao;
import com.example.roomdatabase26112019.model.database.SinhvienDatabase;
import java.util.List;



public class RoomRepository {

    private SinhvienDao sinhvienDao;
    private LiveData<List<Sinhvien>> allSinhVien;

    public RoomRepository(Application application) {
        SinhvienDatabase sinhvienDatabase = SinhvienDatabase.getInstance(application);
        sinhvienDao = sinhvienDatabase.sinhvienDao();
        allSinhVien = sinhvienDao.getAllSinhVien();
    }

    public void insert(Sinhvien sinhvien) {
        new InsertSinhVienAsyncTask(sinhvienDao).execute(sinhvien);
    }
    public void deleteAllSinhVien (){
        new DeleteAllSinhVienAsyncTask(sinhvienDao).execute();
    }
    public LiveData<List<Sinhvien>> getAllSinhVien() {
        return allSinhVien;
    }

    private static class InsertSinhVienAsyncTask extends AsyncTask<Sinhvien, Void, Void> {
        private SinhvienDao sinhvienDao;

        private InsertSinhVienAsyncTask(SinhvienDao sinhvienDao) {
            this.sinhvienDao = sinhvienDao;
        }
        @Override
        protected Void doInBackground(Sinhvien... sinhviens) {
            sinhvienDao.insert(sinhviens[0]);
            return null;
        }
    }

    private static class DeleteAllSinhVienAsyncTask extends AsyncTask<Void, Void, Void> {
        private SinhvienDao sinhvienDao;

        private DeleteAllSinhVienAsyncTask(SinhvienDao sinhvienDao) {
            this.sinhvienDao = sinhvienDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            sinhvienDao.deleteAllSinhvien();
            return null;
        }
    }
}
