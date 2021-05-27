package com.example.sqllite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.sqllite.params.Params;

import static com.example.sqllite.params.Params.TABLE_NAME;

public class DBHandler extends SQLiteOpenHelper {

    private static DBHandler db;


    public DBHandler(Context context) {
        super(context, Params.DATABASE_NAME, null, Params.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase DB) {
        String create = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME + "(" + Params.KEY_ID + "INTEGER PRIMARY KEY,"
                + Params.KEY_NAME + " TEXT,"
                + Params.KEY_COURSE + "TEXT,"
                + Params.KEY_CONTACT + "TEXT,"
                + Params.KEY_FEE + "TEXT" + ")";
        Log.d("ABSK", "QUERY RUN SUCCESSFUL");
        DB.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists info");
        onCreate(DB);

    }

    public void newUser() {
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", "145");
        values.put("name", "Abhishek");
        values.put("course", "C++");
        values.put("contact", "9876543210");
        values.put("fee", "350");

        sq.insert("info", null, values);
        sq.close();
    }

}
//
//    public boolean addData(String item1) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL2, item1);
//
//
//        long result = db.insert(TABLE_NAME, null, contentValues);
//
//        //if date as instered incorrectly it will return -1
//        if (result == -1) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    public Cursor getListContent() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
//        return data;
//
//
//    }