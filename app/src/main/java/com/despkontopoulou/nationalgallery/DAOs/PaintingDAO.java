package com.despkontopoulou.nationalgallery.DAOs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.despkontopoulou.nationalgallery.Contracts.PaintingContract;
import com.despkontopoulou.nationalgallery.PaintingDbHelper;

public class PaintingDAO {
    private final PaintingDbHelper dbHelper;
    public PaintingDAO(Context context){
        dbHelper= new PaintingDbHelper(context);
    }
    public long insertPainting(String title,String image_name,String painter, String category){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values= new ContentValues();//create map of values
        values.put(PaintingContract.PaintingEntry.COLUMN_NAME_TITLE, title);
        values.put(PaintingContract.PaintingEntry.COLUMN_NAME_IMAGE_NAME, image_name);
        values.put(PaintingContract.PaintingEntry.COLUMN_NAME_PAINTER, painter);
        values.put(PaintingContract.PaintingEntry.COLUMN_NAME_CATEGORY, category);
        return db.insert(PaintingContract.PaintingEntry.TABLE_NAME,null, values);
    }
    public Cursor getPaintings(){}


}
