package com.example.module.Module1_database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Module_database {

    private SQLiteDatabase db;
    private Sqlitedb database;
    private Context context;
    public static final String users="CREATE TABLE IF NOT EXISTS user(id integer primary key autoincrement,user_name" +
            " text);";

    public static final String USER_TABLE = "user";
    private static  final String NAME = "MODULE_DB";
    private static final int VERSION = 1;



    public class Sqlitedb extends SQLiteOpenHelper {


        public Sqlitedb(Context context) {
            super(context,NAME ,null ,VERSION );
        }



        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            sqLiteDatabase.execSQL(users);
            Log.v("TABLE CREATED",USER_TABLE);

            sqLiteDatabase.execSQL("INSERT INTO user(user_name) VALUES ('chaitanya')");
            sqLiteDatabase.execSQL("INSERT INTO user(user_name) VALUES ('chaitanya2')");
            sqLiteDatabase.execSQL("INSERT INTO user(user_name) VALUES ('chaitanya3')");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }




    }

    public Module_database(Context context) {
        this.context = context;
    }
    public Module_database Open() throws SQLException {

        database = new Sqlitedb(context);
        db = database.getWritableDatabase();

        return this;
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
