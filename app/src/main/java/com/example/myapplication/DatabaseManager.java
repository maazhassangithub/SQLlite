package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {

    private static String dbName = "aptech.db";
    private static int dbVersion = 1;
    private SQLiteDatabase db;

    public DatabaseManager(Context context){
        super(context, dbName, null, dbVersion);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE students(student_id TEXt, student_name TEXT, course_name TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS students");
        onCreate(db);
    }

    public void addRecord(String id, String name, String course){
        db = this.getWritableDatabase();
        db.execSQL("insert into students values('"+id+"', '"+name+"', '"+course+"')");
        db.close();
    }


    public ArrayList<Student> showRecord(){
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from students", null);

        ArrayList<Student> list = new ArrayList<Student>();
        for(cursor.moveToLast(); !cursor.isBeforeFirst(); cursor.moveToPrevious()){
            Student std = new Student();
            std.setStudentId(cursor.getString(0));
            std.setStudentName(cursor.getString(1));
            std.setCourseName(cursor.getString(2));
            list.add(std);
        }

        return list;

    }

}
