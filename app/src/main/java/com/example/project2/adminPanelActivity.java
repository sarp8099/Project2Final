package com.example.project2;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project2.DB.adminData;
import com.example.project2.DB.appDAO;
import com.example.project2.DB.appDB;

import java.util.List;

public class adminPanelActivity extends AppCompatActivity {
    appDAO appDao;
    List<adminData> data;
    Button addUser;
    Button removeUser;
    Button addEvent;
    Button removeEvent;
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpanel);

        data = appDao.getAdminData();
        addUser = findViewById(R.id.adminpanel_adduser);
        removeUser = findViewById(R.id.adminpanel_removeuser);
        addEvent = findViewById(R.id.adminpanel_addevent);
        removeEvent = findViewById(R.id.adminpanel_removeevent);
        home = findViewById(R.id.adminpanel_home);

        appDao = Room.databaseBuilder(this, appDB.appDatabase.class ,appDB.appDatabase.dbName)
                .allowMainThreadQueries().build().getappDAO();

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });

        removeUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeUser();
            }
        });

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEvent();
            }
        });

        removeEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeEvent();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home();
            }
        });

    }

    public void addUser(){
        Intent intent = new Intent(this, addUserActivity.class);
        startActivity(intent);
    }

    public void removeUser(){
        Intent intent = new Intent(this, removeUserActivity.class);
        startActivity(intent);
    }

    public void addEvent(){
        Intent intent = new Intent(this, addEventActivity.class);
        startActivity(intent);
    }

    public void removeEvent() {
        Intent intent = new Intent(this, removeEventActivity.class);
        startActivity(intent);
    }
    public void home() {
        Intent intent = new Intent(this, adminActivity.class);
        startActivity(intent);
    }
}