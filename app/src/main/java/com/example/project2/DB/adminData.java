package com.example.project2.DB;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = appDB.appDatabase.ADMINDATA_TABLE)
public class adminData {
    @PrimaryKey(autoGenerate = true)
    private int id = 0;

    private String username;
    private Boolean admin = true;

    adminData(){
        this.id = 0;
        this.username = "";
        this.admin = true;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
