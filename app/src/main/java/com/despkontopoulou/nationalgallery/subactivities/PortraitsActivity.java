package com.despkontopoulou.nationalgallery.subactivities;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.despkontopoulou.nationalgallery.PaintingDescription;
import com.despkontopoulou.nationalgallery.R;

public class PortraitsActivity extends PaintingDescription {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_portraits);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //we set the text descriptions for paintings using sharedprefrences

        String text1= preferences.getString("portraits1","desc");
        String text2= preferences.getString("portraits2","desc");
        String text3= preferences.getString("portraits3","desc");
        String text4= preferences.getString("portraits4","desc");
        String[] texts= new String[]{text1,text2,text3,text4};
        int[] imageIDs= new int[]{R.id.image1,R.id.image2,R.id.image3,R.id.image4};
        int[] textIDs= new int[]{R.id.desc1,R.id.desc2,R.id.desc3,R.id.desc4};
        setListeners(imageIDs,textIDs,texts);
    }
}