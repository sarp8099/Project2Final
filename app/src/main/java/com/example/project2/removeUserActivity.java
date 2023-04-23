package com.example.project2;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project2.DB.appDAO;
import com.example.project2.DB.appDB;
import com.example.project2.DB.appData;

import java.util.List;

public class removeUserActivity extends AppCompatActivity {
    appDAO appDao;
    List<appData> data;
    EditText username;
    Button submit;
    TextView notif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_removeuser);

        data = appDao.getData();
        username = findViewById(R.id.removeUser_user);
        submit = findViewById(R.id.removeUser_submit);
        notif = findViewById(R.id.removeUser_notification);

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
        Intent intent = new Intent(this, adminPanelActivity.class);
        startActivity(intent);
    }
}