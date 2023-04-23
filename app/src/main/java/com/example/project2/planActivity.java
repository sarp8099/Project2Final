package com.example.project2;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project2.DB.appDAO;
import com.example.project2.DB.appDB;
import com.example.project2.DB.scheduleData;

import java.util.List;

public class planActivity extends AppCompatActivity {
    appDAO appDao;
    List<scheduleData> data;
    EditText eventName;
    EditText eventDate;
    EditText startTime;
    EditText endTime;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        data = appDao.getScheduleData();

        eventName = findViewById(R.id.planning_eventname);
        eventDate = findViewById(R.id.planning_eventdate);
        startTime = findViewById(R.id.planning_starttime);
        endTime = findViewById(R.id.planning_endtime);

        appDao = Room.databaseBuilder(this, appDB.appDatabase.class ,appDB.appDatabase.dbName)
                .allowMainThreadQueries().build().getappDAO();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });

    }

    public void submit() {
        Intent intent = new Intent(this, userActivity.class);
        startActivity(intent);
    }
}