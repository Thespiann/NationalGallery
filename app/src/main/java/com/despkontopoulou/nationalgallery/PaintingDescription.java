package com.despkontopoulou.nationalgallery;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PaintingDescription extends AppCompatActivity {
    protected boolean isLightened = false;
    protected SharedPreferences preferences;

    @Override
    protected void onStart() {
        super.onStart();
        preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        editPreferences();
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
    private void editPreferences(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("fasianos1","Βυζαντινός Νέος");
        editor.putString("fasianos2","Φτερουγίσματα");
        editor.putString("fasianos3","Χειρομάντης στο δωμάτιο του");
        editor.putString("fasianos4","Πουλιά");

        editor.putString("gkikas1","Η γη");
        editor.putString("gkikas2","Το νερό");
        editor.putString("gkikas3","Ο βράχος");
        editor.putString("gkikas4","Ανταύγιες της φωτιάς");
        editor.putString("gkikas5","Κήπος με κρεμασένα σεντόνια");

        editor.putString("portraits1","Προσωπογραφία γυναίκας,\n Ράλλης Θεόδωρος");
        editor.putString("portraits2","Προσωπογραφία Ζαφείρη Μάτσα,\n Αραβαντινός Πάνος");
        editor.putString("portraits3","Σπουδή προσωπογραφίας,\n Ρόρρης Γιώργος");
        editor.putString("portraits4","Προσωπογραφία γυναίκας,\n Ροϊλός Γεώργιος");

        editor.apply();

    }
}