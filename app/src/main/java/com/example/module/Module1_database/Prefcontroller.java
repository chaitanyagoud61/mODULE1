package com.example.module.Module1_database;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefcontroller {


    public static void save_pref(Context context, String key, String val) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Shared_pref",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,val);

    }

    public static String get_pref_date(Context context,String key){

        SharedPreferences sharedPreferences = context.getSharedPreferences("Shared_pref",Context.MODE_PRIVATE);
        String value = sharedPreferences.getString(key,"");

        return value;
    }

    public static void delete_pref(Context context,String key){

        SharedPreferences sharedPreferences = context.getSharedPreferences("Shared_pref",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
    }
}
