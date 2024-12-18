package com.despkontopoulou.nationalgallery.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.despkontopoulou.nationalgallery.Paintings.Painting;

import java.util.ArrayList;
import java.util.List;

public class PaintingDAO {
    private final PaintingDbHelper dbHelper;
    public PaintingDAO(Context context){
        dbHelper= new PaintingDbHelper(context);
    }
        public void insertPainting(Painting painting){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        try{
            ContentValues values= new ContentValues();//create map of values
            values.put(PaintingContract.PaintingEntry.COLUMN_NAME_TITLE, painting.getTitle());
            values.put(PaintingContract.PaintingEntry.COLUMN_NAME_IMAGE_NAME, painting.getImage_name());
            values.put(PaintingContract.PaintingEntry.COLUMN_NAME_PAINTER, painting.getPainter());
            values.put(PaintingContract.PaintingEntry.COLUMN_NAME_CATEGORY, painting.getCategory());
            db.insert(PaintingContract.PaintingEntry.TABLE_NAME,null, values);
        }finally{
            db.close();
        }
    }

    public void initialize_paintings() {
        if (getAllPaintings().isEmpty()) {
            insertPainting(new Painting("Βυζαντινός Νέος", "fasianos1", "Φασιανός", "Ζωγράφος"));
            insertPainting(new Painting("Φτερουγίσματα", "fasianos2", "Φασιανός", "Ζωγράφος"));
            insertPainting(new Painting("Χειρομάντης στο δωμάτιο του", "fasianos3", "Φασιανός", "Ζωγράφος"));
            insertPainting(new Painting("Πουλιά", "fasianos4", "Φασιανός", "Ζωγράφος"));

            insertPainting(new Painting("Η Γη", "gkikas1", "Γκίκας", "Ζωγράφος"));
            insertPainting(new Painting("Το νερό", "gkikas2", "Γκίκας", "Ζωγράφος"));
            insertPainting(new Painting("Ο βράχος", "gkikas3", "Γκίκας", "Ζωγράφος"));
            insertPainting(new Painting("Ανταύγιες της φωτιάς", "gkikas4", "Γκίκας", "Ζωγράφος"));
            insertPainting(new Painting("Κήπος με κρεμασμένα σεντόνια", "gkikas5", "Γκίκας", "Ζωγράφος"));

            insertPainting(new Painting("Προσωπογραφία γυναίκας,\n Ράλλης Θεόδωρος", "portraits1", "Ράλλης", "Πορτραίτα"));
            insertPainting(new Painting("Προσωπογραφία Ζαφείρη Μάτσα,\n Αραβαντινός Πάνος", "portraits2", "Αραβαντινός", "Πορτραίτα"));
            insertPainting(new Painting("Σπουδή προσωπογραφίας,\n Ρόρρης Γιώργος", "portraits3", "Ρόρρης", "Πορτραίτα"));
            insertPainting(new Painting("Προσωπογραφία γυναίκας,\n Ροϊλός Γεώργιος", "portraits4", "Ροϊλός", "Πορτραίτα"));

        }
    }
    public List<Painting> getAllPaintings(){
        return getPaintingsByQuery(null,null);
    }

    public List<Painting> getPaintingsByPainter(String painter){
        return getPaintingsByQuery(PaintingContract.PaintingEntry.COLUMN_NAME_PAINTER + " = ?", new String[]{painter});
    }
    public List<Painting> getPortraits(){
        return getPaintingsByQuery(PaintingContract.PaintingEntry.COLUMN_NAME_CATEGORY + " = ?", new String[]{"Πορτραίτα"});
    }

    private List<Painting> getPaintingsByQuery(String selection,String[] selectionargs){
        List<Painting> paintings= new ArrayList<>();
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor=null;
        try {
            cursor = db.query(PaintingContract.PaintingEntry.TABLE_NAME, null, selection, selectionargs, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {  // Move to first item
                do {
                    int id = cursor.getInt(cursor.getColumnIndexOrThrow(PaintingContract.PaintingEntry._ID));
                    String title = cursor.getString(cursor.getColumnIndexOrThrow(PaintingContract.PaintingEntry.COLUMN_NAME_TITLE));
                    String image_name = cursor.getString(cursor.getColumnIndexOrThrow(PaintingContract.PaintingEntry.COLUMN_NAME_IMAGE_NAME));
                    String painter = cursor.getString(cursor.getColumnIndexOrThrow(PaintingContract.PaintingEntry.COLUMN_NAME_PAINTER));
                    String category = cursor.getString(cursor.getColumnIndexOrThrow(PaintingContract.PaintingEntry.COLUMN_NAME_CATEGORY));

                    paintings.add(new Painting(id, title, image_name, painter, category));
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
        return paintings;
    }

}