package com.example.vkapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    private Context context;

    public DBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create= "CREATE TABLE employee (COL_ID INTEGER PRIMARY KEY, COL_NAME TEXT)";
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String drop= String.valueOf("DROP TABLE IF EXISTS");
        sqLiteDatabase.execSQL(drop, new String[]{"myemployee"});
        onCreate(sqLiteDatabase);
    }

    public void addEmployee(Employee emp){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", emp.getCOL_NAME());
        values.put("id",emp.getCOL_ID());
        long k = db.insert("myemployee", null, values);
        Log.d("mytag", Long.toString(k));
        db.close();
    }

    public void getEmployee(int C_ID){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("myemployee", new String[]{"COL_ID","COL_NAME"},"COL_ID=?", new String[]{String.valueOf(C_ID)},null,null,null);

        if(cursor!=null && cursor.moveToFirst()){
            Log.d("mytag", cursor.getString(1));
            Log.d("mytag", cursor.getString(2));
        }
        else {
            Log.d("mytag", "Some error occured");
        }
    }
}
