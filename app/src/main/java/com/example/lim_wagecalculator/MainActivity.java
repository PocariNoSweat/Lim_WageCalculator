package com.example.lim_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText employeeName, employeeHours;
    RadioGroup employeeType;
    RadioButton btnSelected;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //EditText
    employeeName = findViewById(R.id.name);
    employeeHours = findViewById(R.id.Hours);
    //RadioGroup
    employeeType = findViewById(R.id.employeeType);
    //Button
    calculate = findViewById(R.id.button);
    //button On click listener
        calculate.setOnClickListener(this);
}

    public void onClick(View v) {


        if (v.getId() == R.id.button) {
            int selectedEmployeeType = employeeType.getCheckedRadioButtonId();

            btnSelected = findViewById(selectedEmployeeType);

            String type = btnSelected.getText().toString();

            String name = employeeName.getText().toString();
            String totalHours = ( employeeHours.getText().toString() );

            Intent intent = new Intent(this, ResultsActivity.class);

            intent.putExtra("type", type);
            intent.putExtra("empName", name);
            intent.putExtra("hours", totalHours);
            startActivity(intent);
        }
    }
}