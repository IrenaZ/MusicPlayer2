package com.example.re3.musictext;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by re3 on 07.06.16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME ="musStore.db";
    private static final int VERSION =1;
    private static final String TABLE = "musTable";


    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PATH = "path";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        String dbQuery =  "CREATE TABLE " + TABLE + "("+COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
             +COLUMN_PATH + " TEXT);";
        db.execSQL(dbQuery);


    }


    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE);
        onCreate(db);
    }


    public Music getMusic(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE,new String[] { COLUMN_ID, COLUMN_PATH},
                COLUMN_ID + "=?", new String[] {String.valueOf(id)}, null,null,null );
        if(cursor != null)
            cursor.moveToFirst();
        Music audios = new Music(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
        return audios;

    }

public int deleteMusic(Music audios){
    SQLiteDatabase db = this.getWritableDatabase();
    return db.delete(TABLE, COLUMN_ID + "=?", new String[]{String.valueOf(audios.getId())});

}

    public void addMusic (Music audios){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_PATH,audios.getPath());
        db.insert(TABLE, null,cv);
        db.close();

    }

    public Cursor getAllCursor(){
        SQLiteDatabase db = this.getReadableDatabase();
        return  db.query(TABLE,null,null,null,null,null,null);

    }


}
