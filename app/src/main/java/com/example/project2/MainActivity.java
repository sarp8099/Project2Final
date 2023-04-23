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
import com.example.project2.DB.adminData;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    appDAO appDao;
    List<appData> data;
    List<adminData> adminData;
    TextView notif;
    EditText username;
    EditText password;

    Button login;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notif = findViewById(R.id.loginpage_notification);
        username = findViewById(R.id.loginpage_user);
        password = findViewById(R.id.loginpage_password);
        login = findViewById(R.id.loginpage_login);
        signup = findViewById(R.id.loginpage_signup);

        appDao = Room.databaseBuilder(this, appDB.appDatabase.class ,appDB.appDatabase.dbName)
                .allowMainThreadQueries().build().getappDAO();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });

    }

    private void refreshDisplay(){
        data = appDao.getData();
        if (! data.isEmpty()) {
            for(appData entry : data){
                if ((entry.getUsername().equals(username.getText()))
                        && (entry.getPassword().equals(password.getText()))){
                    login.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            if (entry.getAdmin().equals(true)){
                                adminLanding();
                            } else {
                                userLanding();
                            }
                        }
                    });
                }
            }
        } else {
            notif.setText("User not recognized, please sign up below!");
        }
    }

    public void adminLanding() {
        Intent intent = new Intent(this, adminActivity.class);
        startActivity(intent);
    }

    public void userLanding() {
        Intent intent = new Intent(this, userActivity.class);
        startActivity(intent);
    }

    public void signup() {
        Intent intent = new Intent(this, signUpActivity.class);
        startActivity(intent);
    }
}