package com.despkontopoulou.nationalgallery;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.despkontopoulou.nationalgallery.DAOs.PaintingDAO;

import java.util.List;


public class PaintingView extends AppCompatActivity {
    protected boolean isLightened = false;
    protected PaintingDAO paintingDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        paintingDAO= new PaintingDAO(this);

        List<Painting> paintings=paintingDAO.getAllPaintings();
    }
    public void showDesc(ImageView img, TextView text){//view is the clicked img
        if(isLightened){
            img.clearColorFilter();// remove lightening
            text.setVisibility(View.INVISIBLE);//hide text
        }else{
            text.setVisibility(View.VISIBLE);//hide text
            img.setColorFilter(0x99FFFFFF, android.graphics.PorterDuff.Mode.SRC_OVER); // make lighter using white overlay
        }
        isLightened=!isLightened;// toggle boolean
    }

    public void setPaintingsByPainter(String painter, int[] imageViewIDs, int[] textViewIDs){
    List<Painting> paintings=paintingDAO.getPaintingsByPainter(painter);
    for (int i=0;i<imageViewIDs.length;i++){
        ImageView imageview= findViewById(imageViewIDs[i]);
        TextView textview= findViewById(textViewIDs[i]);
        Painting painting= paintings.get(i);
        int imageResId=getResources().getIdentifier(painting.getImage_name(), "drawable",getPackageName());
        imageview.setImageResource(imageResId);
        textview.setText(painting.getTitle());
        imageview.setOnClickListener(v->showDesc(imageview,textview));
        }
    }
    public void setPortraits(int[] imageViewIDs, int[] textViewIDs){
        List<Painting> paintings=paintingDAO.getPortraits();
        for (int i=0;i<imageViewIDs.length;i++){
            ImageView imageview= findViewById(imageViewIDs[i]);
            TextView textview= findViewById(textViewIDs[i]);
            Painting painting= paintings.get(i);
            int imageResId=getResources().getIdentifier(painting.getImage_name(), "drawable",getPackageName());
            imageview.setImageResource(imageResId);
            textview.setText(painting.getTitle());
            imageview.setOnClickListener(v->showDesc(imageview,textview));
        }
    }
}
