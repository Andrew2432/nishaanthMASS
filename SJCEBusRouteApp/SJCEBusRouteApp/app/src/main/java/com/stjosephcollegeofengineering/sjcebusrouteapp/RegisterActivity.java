package com.stjosephcollegeofengineering.sjcebusrouteapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button btnRegBack, btnRegStuSub;
    private EditText etStuRegNo, etStuMobNo;
    private Spinner spStuDept, spStuYear, spStuCurBusRoute;
    private String strStuDept, strStuYear, strStuCurBusRoute, strStuRegNo, strStuMobNo;
    private String[] stuDepts = {"CSE", "IT", "CIVIL", "ECE", "EEE", "MBA", "MECH"};
    private String[] stuYears = {"2016-2020", "2017-2021", "2018-2022", "2019-2023"};
    private String[] stuBusRoutes = {"M R Nagar", "IOC", "Tambaram"};
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegStuSub = (Button)findViewById(R.id.registerStudentBtnSubmit);

        etStuRegNo = (EditText)findViewById(R.id.registerStudentInputRegNoEt);
        etStuMobNo = (EditText)findViewById(R.id.registerStudentInputMobNoEt);

        spStuDept = (Spinner)findViewById(R.id.registerStudentDeptSpinner);
        spStuYear = (Spinner)findViewById(R.id.registerStudentYearSpinner);
        spStuCurBusRoute = (Spinner)findViewById(R.id.registerStudentBusRouteSpinner);

        spStuDept.setOnItemSelectedListener(this);
        ArrayAdapter<String> arrayAdapterDept = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, stuDepts);
        arrayAdapterDept.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spStuDept.setAdapter(arrayAdapterDept);

        spStuYear.setOnItemSelectedListener(this);
        ArrayAdapter<String> arrayAdapterYear = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, stuYears);
        arrayAdapterYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spStuYear.setAdapter(arrayAdapterYear);

        spStuCurBusRoute.setOnItemSelectedListener(this);
        ArrayAdapter<String> arrayAdapterCurBusRoute = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, stuBusRoutes);
        arrayAdapterCurBusRoute.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spStuCurBusRoute.setAdapter(arrayAdapterCurBusRoute);



        btnRegBack = (Button)findViewById(R.id.registerBtnBack);
        btnRegBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginUserActivity.class);
                startActivity(intent);
            }
        });


        btnRegStuSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strStuRegNo = etStuRegNo.getText().toString();
                strStuMobNo = etStuMobNo.getText().toString();

                addStudent(strStuRegNo, strStuDept, strStuYear, strStuMobNo, strStuCurBusRoute);
            }
        });


    }

    private void addStudent(String regNo,  String dept, String year, String mobNo, String curBusRoute) {
        db = FirebaseFirestore.getInstance();

        Map<String, Object> student = new HashMap<>();
        student.put("registration number", regNo);
        student.put("department", dept);
        student.put("year", year);
        student.put("mobile number", mobNo);
        student.put("current bus route", curBusRoute);

        db.collection("students")
                .add(student)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("success", "Document added with ID:"+ documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("failure", "Error adding documents", e);
                    }
                });

    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(), LoginUserActivity.class));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        strStuDept = spStuDept.getSelectedItem().toString();
        strStuYear = spStuYear.getSelectedItem().toString();
        strStuCurBusRoute = spStuCurBusRoute.getSelectedItem().toString();
        Toast.makeText(this, strStuYear + strStuDept + strStuCurBusRoute, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
