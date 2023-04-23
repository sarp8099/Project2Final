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

public class adminActivity extends AppCompatActivity {
    appDAO appDao;
    List<adminData> data;
    Button plan;
    Button cancel;
    Button schedule;
    Button adminPanel;
    Button signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlanding);

        data = appDao.getAdminData();
        plan = findViewById(R.id.adminlanding_plan);
        cancel = findViewById(R.id.adminlanding_cancel);
        schedule = findViewById(R.id.adminlanding_schedule);
        adminPanel = findViewById(R.id.adminlanding_adminpanel);
        signOut = findViewById(R.id.adminlanding_signout);

        appDao = Room.databaseBuilder(this, appDB.appDatabase.class ,appDB.appDatabase.dbName)
                .allowMainThreadQueries().build().getappDAO();

        adminPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adminPanel();
            }
        });

        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSchedule();
            }
        });

        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPlanner();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelPlanner();
            }
        });

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPage();
            }
        });

    }

    public void adminPanel(){
        Intent intent = new Intent(this, adminPanelActivity.class);
        startActivity(intent);
    }

    public void openSchedule(){
        Intent intent = new Intent(this, scheduleActivity.class);
        startActivity(intent);
    }

    public void cancelPlanner(){
        Intent intent = new Intent(this, cancelActivity.class);
        startActivity(intent);
    }

    public void openPlanner() {
        Intent intent = new Intent(this, planActivity.class);
        startActivity(intent);
    }
    public void loginPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}