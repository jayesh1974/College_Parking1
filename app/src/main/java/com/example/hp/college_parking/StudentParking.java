package com.example.hp.college_parking;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import java.sql.Array;
import java.sql.SQLException;
import java.util.Random;

public class StudentParking extends AppCompatActivity{

    DatabaseHelper mDatabaseHelper;

    EditText sap_id;
    ImageButton spot1,spot2, spot3, spot4;
    TextView hello, open, booked;
    int[] count = {0};
    int[] count1 = {0};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_parking);

        sap_id = findViewById(R.id.editText2);
        spot1 = findViewById(R.id.imageButton2);
        spot2 = findViewById(R.id.imageButton7);
        spot3 = findViewById(R.id.imageButton4);
        spot4 = findViewById(R.id.imageButton3);

        booked =  findViewById(R.id.textView6);
        open =  findViewById(R.id.textView3);

        mDatabaseHelper = new DatabaseHelper(this);

        getSupportActionBar().hide();

        spot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = sap_id.getText().toString();
                spot1.setBackground(getResources().getDrawable(R.drawable.ic_launcher_background));
                spot1.setClickable(false);
                count[0] = count[0] +1;
                if(sap_id.length() != 0){
                    AddData(newEntry);
                    sap_id.setText("");
                }
                else {Toast.makeText(StudentParking.this,"Put something in text field!", Toast.LENGTH_SHORT).show();}
            }
        });

        spot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = sap_id.getText().toString();
                spot2.setBackground(getResources().getDrawable(R.drawable.ic_launcher_background));
                spot2.setClickable(false);
                count[0] = count[0] +1;
                if(sap_id.length() != 0){
                    AddData(newEntry);
                    sap_id.setText("");
                }
                else {Toast.makeText(StudentParking.this,"Put something in text field!", Toast.LENGTH_SHORT).show();}
            }
        });

        spot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = sap_id.getText().toString();
                spot3.setBackground(getResources().getDrawable(R.drawable.ic_launcher_background));
                spot3.setClickable(false);
                count[0] = count[0] +1;
                if(sap_id.length() != 0){
                    AddData(newEntry);
                    sap_id.setText("");
                }
                else {Toast.makeText(StudentParking.this,"Put something in text field!", Toast.LENGTH_SHORT).show();}
            }
        });

        spot4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = sap_id.getText().toString();
                spot4.setBackground(getResources().getDrawable(R.drawable.ic_launcher_background));
                spot4.setClickable(false);
                count[0] = count[0] +1;
                if(sap_id.length() != 0){
                    AddData(newEntry);
                    sap_id.setText("");
                }
                else {Toast.makeText(StudentParking.this,"Put something in text field!", Toast.LENGTH_SHORT).show();}
            }
        });
    }

    public void AddData(String newEntry){
        boolean insertData = mDatabaseHelper.addData(newEntry);
        if(insertData){
            Toast.makeText(StudentParking.this,"Successfully booked spot!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(StudentParking.this, ListDataActivity.class );
            startActivity(intent);

            booked.setText(String.valueOf(count[0]));
            count1[0] = 4 - count[0];
            open.setText(String.valueOf(count1[0]));

        }
        else{
            Toast.makeText(StudentParking.this,"Something went wrong!", Toast.LENGTH_SHORT).show();
        }

    }
}
