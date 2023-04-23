package com.example.project2;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project2.DB.appDAO;
import com.example.project2.DB.appDB;
import com.example.project2.DB.appData;

import java.util.List;

public class userActivity extends AppCompatActivity {
    appDAO appDao;
    List<appData> data;
    Button plan;
    Button cancel;
    Button schedule;
    Button signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlanding);

        data = appDao.getData();
        plan = findViewById(R.id.userlanding_plan);
        cancel = findViewById(R.id.userlanding_cancel);
        schedule = findViewById(R.id.userlanding_schedule);
        signOut = findViewById(R.id.userlanding_signout);

        appDao = Room.databaseBuilder(this, appDB.appDatabase.class ,appDB.appDatabase.dbName)
                .allowMainThreadQueries().build().getappDAO();

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