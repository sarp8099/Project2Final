package com.example.project2.DB;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = appDB.appDatabase.APPDATA_TABLE)
public class appData {
    @PrimaryKey(autoGenerate = true)
    private int id = 0;

    private String username;
    private String password;
    private String email;
    private Boolean admin = false;

    appData(){
        this.id = 0;
        this.username = "";
        this.password = "";
        this.email = "";
        this.admin = false;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
