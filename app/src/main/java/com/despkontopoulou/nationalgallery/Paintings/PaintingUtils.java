package com.despkontopoulou.nationalgallery.Paintings;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.despkontopoulou.nationalgallery.Database.PaintingDAO;
import com.despkontopoulou.nationalgallery.TextToSpeech.Tts;

import java.util.List;


public class PaintingUtils extends AppCompatActivity {
    protected boolean isLightened = false;
    private Tts tts;
    protected PaintingDAO paintingDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        paintingDAO = new PaintingDAO(this);
        tts = new Tts(this, new Tts.TtsInitListener() {
            @Override
            public void onTtsInitialized(boolean isSuccessful) {
                if (isSuccessful) {
                    // TTS Initialized successfully
                    Toast.makeText(PaintingUtils.this, "TTS Initialized", Toast.LENGTH_SHORT).show();
                } else {
                    // Initialization failed
                    Toast.makeText(PaintingUtils.this, "TTS Initialization failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void showDesc(ImageView img, TextView text){//view is the clicked img
        if(isLightened){
            img.clearColorFilter();// remove lightening
            text.setVisibility(View.INVISIBLE);//hide text
        }else{
            text.setVisibility(View.VISIBLE);//hide text
            img.setColorFilter(0x99FFFFFF, android.graphics.PorterDuff.Mode.SRC_OVER); // make lighter using white overlay
            String title= text.getText().toString();
            tts.speech(title);
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
