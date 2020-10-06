package com.example.employee_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class welcome extends AppCompatActivity {
    ImageView imgWelcome;
    private TextView txtGrowBusiness, txtWeTrack;
    private Button btnSignIn, btnLogIn, btnHowWeWork;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        txtGrowBusiness = findViewById(R.id.txtGrowBusiness);
        txtWeTrack = findViewById(R.id.txtWeTrack);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnLogIn = findViewById(R.id.btnLogIn);
        btnHowWeWork = findViewById(R.id.btnHowWeWork);
    }
}