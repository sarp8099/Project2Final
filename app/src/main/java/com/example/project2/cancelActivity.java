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

public class cancelActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_cancelplanning);

        data = appDao.getScheduleData();

        eventName = findViewById(R.id.cancelplanning_eventname);
        eventDate = findViewById(R.id.cancelplanning_eventdate);
        startTime = findViewById(R.id.cancelplanning_starttime);
        endTime = findViewById(R.id.cancelplanning_endtime);

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