package com.example.sqllite;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqllite.data.DBHandler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etId, etName, etCourse, etContact, etFee;
    Button btnSave, btnDelete, btnUpdate, btnSearch, btnPrevious, btnNext, btnShow, btnShowAll, btnClear;

    int id;
    String contact;
    String fee;
    String name, course;
    SQLiteDatabase sq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etId = findViewById(R.id.etId);
        etName = findViewById(R.id.etName);
        etContact = findViewById(R.id.etCourse);
        etCourse = findViewById(R.id.etContact);
        etFee = findViewById(R.id.etFee);

        btnSave = findViewById(R.id.btnSave);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnSearch = findViewById(R.id.btnSearch);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);
        btnShow = findViewById(R.id.btnShow);
        btnShowAll = findViewById(R.id.btnShowAll);
        btnClear = findViewById(R.id.btnClear);

        sq = openOrCreateDatabase("record", Context.MODE_PRIVATE, null);
        DBHandler dbHandler = new DBHandler(this);


        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnShow.setOnClickListener(this);
        btnShowAll.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnSave) {

            id = Integer.parseInt(etId.getText().toString());
            name = etName.getText().toString();
            course = etCourse.getText().toString();
            contact = etContact.getText().toString();
            fee = etFee.getText().toString();

           sq.execSQL("insert into info values(" + id + ",'" + name + "','" + course + "'," + fee + "," + contact + ");");

            Toast.makeText(this, "DATA SAVED", Toast.LENGTH_SHORT).show();
        } else if (view == btnDelete) {
            Toast.makeText(this, "DELETE BUTTON CLICKED", Toast.LENGTH_SHORT).show();

        } else if (view == btnNext) {
            Toast.makeText(this, "NEXT BUTTON CLICKED", Toast.LENGTH_SHORT).show();

        } else if (view == btnPrevious) {
            Toast.makeText(this, "PREVIOUS BUTTON CLICKED", Toast.LENGTH_SHORT).show();

        } else if (view == btnShow) {
            Toast.makeText(this, "SHOW BUTTON CLICKED", Toast.LENGTH_SHORT).show();

        } else if (view == btnUpdate) {
            Toast.makeText(this, "UPDATE BUTTON CLICKED", Toast.LENGTH_SHORT).show();

        } else if (view == btnSearch) {
            Toast.makeText(this, "SEARCH BUTTON CLICKED", Toast.LENGTH_SHORT).show();

        } else if (view == btnShowAll) {
            startActivity(new Intent(getApplicationContext(), ShowAllActivity.class));
            finish();

        } else if (view == btnClear) {
            Toast.makeText(this, "Fields DATA Cleared...", Toast.LENGTH_SHORT).show();
            etId.setText("");
            etName.setText("");
            etContact.setText("");
            etCourse.setText("");
            etFee.setText("");
        }
    }


}