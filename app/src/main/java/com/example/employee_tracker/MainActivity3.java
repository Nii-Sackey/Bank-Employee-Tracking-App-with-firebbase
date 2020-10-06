package com.example.employee_tracker;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    private TextView txtName, txtAccNumber, txtAmount;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        txtName = findViewById(R.id.txtName);
        txtAccNumber = findViewById(R.id.txtAccNumber);
        txtAmount =  findViewById(R.id.txtAmount);

        btnSubmit = findViewById(R.id.btnSubmit);
    }
}