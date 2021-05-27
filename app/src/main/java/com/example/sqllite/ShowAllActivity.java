package com.example.sqllite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqllite.data.DBHandler;
import com.example.sqllite.params.Params;

import java.util.ArrayList;

import static com.example.sqllite.params.Params.KEY_CONTACT;
import static com.example.sqllite.params.Params.KEY_COURSE;
import static com.example.sqllite.params.Params.KEY_FEE;
import static com.example.sqllite.params.Params.KEY_ID;
import static com.example.sqllite.params.Params.KEY_NAME;

public class ShowAllActivity extends AppCompatActivity {

    DBHandler dbHandler;
    SQLiteDatabase sq;
    CustomAdapter ca;
    Cursor cursor;
    Button btnBack;


    ArrayList<Integer> ID_ArrayList = new ArrayList<>();
    ArrayList<String> NAME_ArrayList = new ArrayList<>();
    ArrayList<String> COURSE_ArrayList = new ArrayList<>();
    ArrayList<String> CONTACT_ArrayList = new ArrayList<>();
    ArrayList<String> FEE_ArrayList = new ArrayList<>();
    ListView lv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        lv = findViewById(R.id.lv);
        dbHandler = new DBHandler(this);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        ShowSQLiteDB();
        super.onResume();
    }

    private void ShowSQLiteDB(){

        sq=dbHandler.getWritableDatabase();
        cursor=sq.rawQuery("SELECT * FROM info",null);

        ID_ArrayList.clear();
        NAME_ArrayList.clear();
        COURSE_ArrayList.clear();
        CONTACT_ArrayList.clear();
        FEE_ArrayList.clear();

        if (cursor.moveToFirst()){

            ID_ArrayList.add(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
            NAME_ArrayList.add(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            COURSE_ArrayList.add(cursor.getString(cursor.getColumnIndex(KEY_COURSE)));
            CONTACT_ArrayList.add(cursor.getString(cursor.getColumnIndex(KEY_CONTACT)));
            FEE_ArrayList.add(cursor.getString(cursor.getColumnIndex(KEY_FEE)));

        } while (cursor.moveToNext());

        dbHandler = new CustomAdapter(ShowAllActivity.this,
                ID_ArrayList,
                NAME_ArrayList,
                COURSE_ArrayList,
                CONTACT_ArrayList,
                FEE_ArrayList
        );

        lv.setAdapter(dbHandler);
        cursor.close();
    }
}