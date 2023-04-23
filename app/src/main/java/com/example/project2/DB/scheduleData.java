package com.example.project2.DB;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = appDB.appDatabase.SCHEDDATA_TABLE)
public class scheduleData {
    @PrimaryKey(autoGenerate = true)
    private int id = 0;
    private String eventName;
    private String eventDate;
    private String startTime;
    private String endTime;

    scheduleData(){
        this.id = 0;
        this.endTime = "";
        this.startTime = "";
        this.eventName = "";
        this.eventDate = "";
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

