package com.despkontopoulou.nationalgallery.SubActivities;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.despkontopoulou.nationalgallery.Paintings.PaintingUtils;
import com.despkontopoulou.nationalgallery.R;

public class GkikasActivity extends PaintingUtils {
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
        int[] imageIDs= new int[]{R.id.image1,R.id.image2,R.id.image3,R.id.image4,R.id.image5};
        int[] textIDs= new int[]{R.id.desc1,R.id.desc2,R.id.desc3,R.id.desc4,R.id.desc5};
        setPaintingsByPainter("Γκίκας", imageIDs,textIDs);

    }

}