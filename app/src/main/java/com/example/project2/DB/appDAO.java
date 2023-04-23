package com.example.project2.DB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao @SuppressWarnings("unused")
public interface appDAO {
    //  appData
    @Insert
    void insert(appData... data);

    @Update
    void update(appData... data);

    @Delete
    void delete(appData... data);

    @Query("SELECT * FROM " + appDB.appDatabase.APPDATA_TABLE)
    List<appData> getData();

    //@Query("SELECT * FROM " + appDB.appDatabase.APPDATA_TABLE)
    //List<appData> getWithAppID(int id);

    //  scheduleData
    @Insert
    void insert(scheduleData... data);

    @Update
    void update(scheduleData... data);

    @Delete
    void delete(scheduleData... data);

    @Query("SELECT * FROM " + appDB.appDatabase.SCHEDDATA_TABLE)
    List<scheduleData> getScheduleData();

    //@Query("SELECT * FROM " + appDB.appDatabase.SCHEDDATA_TABLE)
    //List<scheduleData> getWithName(int name);

    //  adminData
    @Insert
    void insert(adminData... data);

    @Update
    void update(adminData... data);

    @Delete
    void delete(adminData... data);

    @Query("SELECT * FROM " + appDB.appDatabase.ADMINDATA_TABLE)
    List<adminData> getAdminData();

    //@Query("SELECT * FROM " + appDB.appDatabase.ADMINDATA_TABLE)
    //List<adminData> getWithAdminName(int name);
}
