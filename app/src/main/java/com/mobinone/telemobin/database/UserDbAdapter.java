package com.mobinone.telemobin.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mobinone.telemobin.models.Users;

public class UserDbAdapter extends TelemobinDb {
    public UserDbAdapter(Context context) {
        super(context);
    }


    public long insertUser(Users user) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(TelemobinDb.KEY_USERNAME, user.getUserName());
        contentValues.put(TelemobinDb.KEY_PASSWORD, user.getPassword());

        return db.insert(TelemobinDb.TABLE_USERS, null, contentValues);

    }


    public long updatePass(Users users) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TelemobinDb.KEY_PASSWORD, users.getPassword());
        return db.update(TelemobinDb.TABLE_USERS, contentValues, KEY_ID + "=" + users.getId(), null);
    }

    public long deleteUser(Users users) {

        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TelemobinDb.TABLE_USERS, KEY_ID + "=" + users.getId(), null);

    }

    public long deleteUser() {

        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TelemobinDb.TABLE_USERS, null, null);

    }


    public int login(Users users){

        int result=0;

        String query="select * from "+TABLE_USERS+" where "+KEY_USERNAME+
                " = '"+users.getUserName()+"' and "+
                KEY_PASSWORD+" = '"+users.getPassword()+"'";


        SQLiteDatabase db=getReadableDatabase();

       Cursor cursor= db.rawQuery(query,null);

       if(cursor.moveToNext()){

           int id=cursor.getInt(0);
           String name=cursor.getString(cursor.getColumnIndex(KEY_USERNAME));
            result=id;
       }





        return result;
    }




}
