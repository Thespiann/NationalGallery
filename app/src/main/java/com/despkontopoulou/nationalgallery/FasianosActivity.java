package com.despkontopoulou.nationalgallery;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FasianosActivity extends PaintingDescription {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fasianos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        //we set the text descriptions for paintings using sharedprefrences
        String text1= preferences.getString("fasianos1","desc");
        String text2= preferences.getString("fasianos2","desc");
        String text3= preferences.getString("fasianos3","desc");
        String text4= preferences.getString("fasianos4","desc");

        ImageView img1 = findViewById(R.id.image1);
        TextView txt1 = findViewById(R.id.fasianos1);
        txt1.setText(text1);

        ImageView img2 = findViewById(R.id.image2);
        TextView txt2 = findViewById(R.id.fasianos2);
        txt2.setText(text2);

        ImageView img3 = findViewById(R.id.image3);
        TextView txt3 = findViewById(R.id.fasianos3);
        txt3.setText(text3);

        ImageView img4 = findViewById(R.id.image4);
        TextView txt4 = findViewById(R.id.fasianos4);
        txt4.setText(text4);

        img1.setOnClickListener(v-> showDesc(img1,txt1));
        img2.setOnClickListener(v-> showDesc(img2,txt2));
        img3.setOnClickListener(v-> showDesc(img3,txt3));
        img4.setOnClickListener(v-> showDesc(img4,txt4));

    }
}