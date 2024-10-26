package com.despkontopoulou.nationalgallery;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GkikasActivity extends PaintingDescription {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gkikas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String text1= preferences.getString("gkikas1","desc");
        String text2= preferences.getString("gkikas2","desc");
        String text3= preferences.getString("gkikas3","desc");
        String text4= preferences.getString("gkikas4","desc");
        String text5= preferences.getString("gkikas5","desc");
        String[] texts= new String[]{text1,text2,text3,text4,text5};

        int[] imageIDs= new int[]{R.id.image1,R.id.image2,R.id.image3,R.id.image4,R.id.image5};
        int[] textIDs= new int[]{R.id.desc1,R.id.desc2,R.id.desc3,R.id.desc4,R.id.desc5};
        setListeners(imageIDs,textIDs,texts);

    }

}