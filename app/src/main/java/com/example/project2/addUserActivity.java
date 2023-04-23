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
import com.example.project2.DB.*;

import java.util.List;

public class addUserActivity extends AppCompatActivity {
    appDAO appDao;
    List<appData> data;
    EditText username;
    EditText email;
    EditText password;
    EditText rePassword;
    Button submit;

    TextView notif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);

        data = appDao.getData();
        username = findViewById(R.id.addUser_user);
        email = findViewById(R.id.addUser_email);
        password = findViewById(R.id.addUser_password);
        rePassword = findViewById(R.id.addUser_password_verify);
        submit = findViewById(R.id.addUser_submit);
        notif = findViewById(R.id.addUser_notification);

        appDao = Room.databaseBuilder(this, appDB.appDatabase.class ,appDB.appDatabase.dbName)
                .allowMainThreadQueries().build().getappDAO();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rePassword == password){
                    submit();
                } else {
                    notif.setText("Passwords do not match, please try again.");
                }
            }
        });

    }

    public void submit() {
        Intent intent = new Intent(this, adminPanelActivity.class);
        startActivity(intent);
    }
}