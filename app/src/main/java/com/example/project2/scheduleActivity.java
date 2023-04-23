package com.example.project2;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project2.DB.appDAO;
import com.example.project2.DB.appDB;
import com.example.project2.DB.scheduleData;

import java.util.List;

public class scheduleActivity extends AppCompatActivity {
    appDAO appDao;
    List<scheduleData> data;
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        data = appDao.getScheduleData();

        appDao = Room.databaseBuilder(this, appDB.appDatabase.class ,appDB.appDatabase.dbName)
                .allowMainThreadQueries().build().getappDAO();

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home();
            }
        });

    }

    public void home() {
        Intent intent = new Intent(this, userActivity.class);
        startActivity(intent);
    }
}