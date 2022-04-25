package com.example.lim_wagecalculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtName;
    TextView txtType;
    TextView txtHours;
    TextView txtTotalWage;
    TextView txtRegularWage;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_activity);

        txtName = findViewById(R.id.employeename);
        txtType = findViewById(R.id.employeetype);
        txtHours = findViewById(R.id.HRresult);
        txtTotalWage = findViewById(R.id.TWRresult);
        txtRegularWage = findViewById(R.id.TRWresult);

        Button btnback = findViewById(R.id.btnback);
        btnback.setOnClickListener(this);


        Intent i = getIntent();

        String EmployeeType = i.getStringExtra("type");
        String EmployeeName = i.getStringExtra("empName");
        Double EmployeeHours = Double.parseDouble(i.getStringExtra("hours"));


        txtName.setText("Employee Name: " + EmployeeName);
        txtType.setText("Employee Type: " + EmployeeType);
        txtHours.setText(String.valueOf(EmployeeHours));
        calcWage(EmployeeType, EmployeeHours, txtTotalWage, txtRegularWage);


    }

    @SuppressLint("SetTextI18n")
    public void calcWage(String employeeType, Double employeeHours, TextView txtTotalWage, TextView txtRegularWage) {
        double totalWage = 0.0;


        if (employeeHours > 8.0) {
        } else {
            if (employeeType.equals("Regular Employee")) {
                totalWage = employeeHours * 100;
                txtTotalWage.setText("₱" + totalWage);
                txtRegularWage.setText("₱" + totalWage);
            }
            if (employeeType.equals("Part-Time Worker")) {
                totalWage = employeeHours * 75;
                txtTotalWage.setText("₱" + totalWage);
                txtRegularWage.setText("₱" + totalWage);
            }
            if (employeeType.equals("Probationary Employee")) {
                totalWage = employeeHours * 90;
                txtTotalWage.setText("₱" + totalWage);
                txtRegularWage.setText("₱" + totalWage);
            }
        }
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnback) {
            startActivity(new Intent(ResultsActivity.this, MainActivity.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }
}


