package com.example.project2.DB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

public class appDB {
    @Database(entities = {appData.class, adminData.class, scheduleData.class}, version =1)
    public abstract class appDatabase extends RoomDatabase {
        public static final String dbName="db_appDB_planner";
        public static final String APPDATA_TABLE="app_login_data";
        public static final String SCHEDDATA_TABLE="app_schedule_data";
        public static final String ADMINDATA_TABLE="app_admin_data";
        public abstract appDAO getappDAO();

    }
}
