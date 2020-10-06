package com.example.employee_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainActivity4 {
    private Button btnFieldcollection, btnCustomers, btnFieldBanking, btnMobileMoney, btnOther, btnAllActivies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFieldcollection = findViewById(R.id.btnFieldCollection);
        btnFieldcollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }

        });
        btnCustomers = findViewById(R.id.btnCustomers);
        btnFieldBanking= findViewById(R.id.btnFieldBanking);
        btnMobileMoney = findViewById(R.id.btnMobileMoney);
        btnOther = findViewById(R.id.btnOther);
        btnAllActivies = findViewById(R.id.btnAllActivities);

/*
        btnFieldcollection.setOnClickListener(this);
        btnCustomers.setOnClickListener(this);
        btnFieldBanking.setOnClickListener(this);
        btnMobileMoney.setOnClickListener(this);
        btnOther.setOnClickListener(this);
        btnAllActivies.setOnClickListener(this);

*/
    }



   // @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFieldCollection:
                Toast.makeText(this, "Field Collection was Clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnCustomers:
                Toast.makeText(this, "Customers was Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnFieldBanking:
                Toast.makeText(this, "Field Banking was Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnMobileMoney:
                Toast.makeText(this, "Field Collection was Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnOther:
                Toast.makeText(this, "Field Collection was Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAllActivities:
                Toast.makeText(this, "Field Collection was Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        }



    }
