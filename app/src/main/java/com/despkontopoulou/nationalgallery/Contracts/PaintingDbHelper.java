package com.despkontopoulou.nationalgallery.Contracts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PaintingDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="NationalGallery.db";
    private static final int DATABASE_VERSION=1;
    //sql table creation
    private static final String SQL_CREATE_ENTRIES=
            "CREATE TABLE "+ PaintingContract.PaintingEntry.TABLE_NAME +"("+
                    PaintingContract.PaintingEntry._ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    PaintingContract.PaintingEntry.COLUMN_NAME_TITLE+ " TEXT,"+
                    PaintingContract.PaintingEntry.COLUMN_NAME_IMAGE_NAME+" TEXT,"+
                    PaintingContract.PaintingEntry.COLUMN_NAME_PAINTER+ " TEXT,"+
                    PaintingContract.PaintingEntry.COLUMN_NAME_CATEGORY+" TEXT)";

    private static final String SQL_DELETE_ENTRIES= "DROP TABLE IF EXISTS "+PaintingContract.PaintingEntry.TABLE_NAME;

    public PaintingDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);//calling constructor of parent class and passing required parameters
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);//create table again
    }
}
