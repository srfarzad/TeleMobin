package com.mobinone.telemobin.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TelemobinDb extends SQLiteOpenHelper {

    public static final String KEY_DB="TlMobin.db";
    public static final String TABLE_USERS="tbl_users";
    public static final String KEY_USERNAME="userName";
    public static final String KEY_PASSWORD="password";
    public static final String KEY_ID="id";



    public TelemobinDb(Context context) {
        super(context, KEY_DB, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String query="create table "+TABLE_USERS+"(id INTEGER PRIMARY KEY AUTOINCREMENT , " +
                KEY_USERNAME+"  Text,"+KEY_PASSWORD+" Text)";

        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
