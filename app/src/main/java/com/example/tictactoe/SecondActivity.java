package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SecondActivity extends AppCompatActivity {
    Button saveData;
    EditText EditTextUserName;
    DatabaseReference databaseUsers;
    int player1Points;
    int player2Points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        if(intent!=null&&intent.hasExtra("player1Points") && intent.hasExtra("player2Points")){
            player1Points = intent.getIntExtra("player1Points", 0);
            player2Points = intent.getIntExtra("player2Points", 0);
        }
        saveData = (Button) findViewById(R.id.save_button);
        databaseUsers = FirebaseDatabase.getInstance().getReference("Users");
        EditTextUserName = (EditText) findViewById(R.id.save_username);
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData(player1Points, player2Points);
            }
        });
    }
    private void addData(int p1, int p2){
        String userName = EditTextUserName.getText().toString().trim();
        if(!TextUtils.isEmpty(userName)){
            String id = databaseUsers.push().getKey();
            UserRecord u = new UserRecord(id, userName, p1, p2);
            databaseUsers.child(id).setValue(u);
            Toast.makeText(this, "Score succesfully stored", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Your username can't be empty", Toast.LENGTH_LONG).show();
        }
    }
}