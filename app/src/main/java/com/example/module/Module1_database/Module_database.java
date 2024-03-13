package com.example.module.Module1_database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Module_database {

    public SQLiteDatabase db;
    public Sqlitedb database;
    public Context context;
    public Module_database moduleDatabase;

    private static  final String NAME = "MODULE_DB";
    private static final int VERSION = 1;


    public Module_database(Context context) {
        this.context = context;
    }

    public Module_database Open() throws SQLException {

        moduleDatabase = new Module_database(context);
        db = database.getWritableDatabase();

        return this;
    }

    public class Sqlitedb extends SQLiteOpenHelper {

        public String users="CREATE TABLE IF NOT EXISTS user(id INTEGER PRIMARY KEY AUTOINCREMENT,user_name" +
                " text)";

        public String USER_TABLE = "user";
        public Sqlitedb(Context context) {
            super(context,NAME ,null ,VERSION );
        }



        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            db.execSQL(users,null);
            Log.v("TABLE CREATED",USER_TABLE);

            db.execSQL("INSERT INTO user(user_name) VALUES ('chaitanya')");
            db.execSQL("INSERT INTO user(user_name) VALUES ('chaitanya2')");
            db.execSQL("INSERT INTO user(user_name) VALUES ('chaitanya3')");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }




    }

    public Cursor getusers(){

        Cursor cursor=null;
        try{
            cursor = db.rawQuery("Select * from user",null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  cursor;
    }
}
