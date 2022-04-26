package com.example.lim_wagecalculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtName, txtType, txtHours, txtTotalWage, txtRegularWage, txtOTWage;


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
        txtOTWage = findViewById(R.id.OTresult);

        Button btnback = findViewById(R.id.btnback);
        btnback.setOnClickListener(this);


        Intent i = getIntent();

        String EmployeeType = i.getStringExtra("type");
        String EmployeeName = i.getStringExtra("empName");
        Double EmployeeHours = Double.parseDouble(i.getStringExtra("hours"));


        txtName.setText("Employee Name: " + EmployeeName);
        txtType.setText("Employee Type: " + EmployeeType);
        txtHours.setText(String.valueOf(EmployeeHours));
        calcWage(EmployeeType, EmployeeHours, txtTotalWage, txtRegularWage,txtOTWage);


    }

    @SuppressLint("SetTextI18n")
    public void calcWage(String employeeType, Double employeeHours, TextView txtTotalWage, TextView txtRegularWage, TextView txtOTWage) {
        double totalWage = 0.0;
        double totalOTWage = 0.0;

        switch (employeeType) {
            case "Regular Employee":
                if (employeeHours > 8.0) { //If employee hours is more than 8 hours
                    employeeHours = employeeHours - 8;
                    totalWage = (employeeHours * 115) + 800;
                    totalOTWage = employeeHours * 115;

                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱800");
                    txtOTWage.setText("₱" + totalOTWage);
                } else { //If employee hours is less than or equal to 8 hours
                    totalWage = employeeHours * 100;
                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱" + totalWage);
                }
                break;
            case "Part-Time Worker":
                if (employeeHours > 8.0) { //If employee hours is more than 8 hours
                    employeeHours = employeeHours - 8;
                    totalWage = (employeeHours * 90) + 600;
                    totalOTWage = employeeHours * 90;

                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱600");
                    txtOTWage.setText("₱" + totalOTWage);
                } else { //If employee hours is less than or equal to 8 hours
                    totalWage = employeeHours * 75;
                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱" + totalWage);
                }
                break;
            case "Probationary Employee":
                if (employeeHours > 8.0) { //If employee hours is more than 8 hours
                    employeeHours = employeeHours - 8;
                    totalWage = (employeeHours * 100) + 720;
                    totalOTWage = employeeHours * 100;

                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱720");
                    txtOTWage.setText("₱" + totalOTWage);
                } else { //If employee hours is less than or equal to 8 hours
                    totalWage = employeeHours * 90;
                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱" + totalWage);
                }
                break;
        }
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnback) { //Return To Main Activity
            startActivity(new Intent(ResultsActivity.this, MainActivity.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }
}

//Wage Calculator
// Regular Employee:
// 1-8 hours(regular work time): 100 pesos per hour
// overtime(calculated each hour after the 8th work hour): 115 pesos per hour
// Probationary Employee:
// 1-8 hours: 90 pesos per hour
// overtime: 100 pesos per hour
// 90 x 8 = 720 pesos for that day
// 720 + (3 * 100) = 1020 for that day
// Part-time workers:
// 1-8 hours: 75 pesos per hour
// overtime: 90 pesos per hour
//Inputs:
// Name
// Employee type
// how many hours you have worked for that day
//Outputs:
// Display:
//      Total Wage Received
//      Total OT wage (if available)
//      Total Regular wage
//      hours rendered
//      hours OT (if available)


