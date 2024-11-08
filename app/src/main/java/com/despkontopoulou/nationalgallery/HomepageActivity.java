package com.despkontopoulou.nationalgallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.despkontopoulou.nationalgallery.subactivities.FasianosActivity;
import com.despkontopoulou.nationalgallery.subactivities.GkikasActivity;
import com.despkontopoulou.nationalgallery.subactivities.PortraitsActivity;

public class HomepageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_homepage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void fasianosView(View view){
        startActivity(new Intent(HomepageActivity.this, FasianosActivity.class));
    }
    public void gkikasView(View view){
        startActivity(new Intent(HomepageActivity.this, GkikasActivity.class));

    }
    public void portraitsView(View view){
        startActivity(new Intent(HomepageActivity.this, PortraitsActivity.class));
    }
}