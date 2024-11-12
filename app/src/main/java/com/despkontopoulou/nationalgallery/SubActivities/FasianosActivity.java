package com.despkontopoulou.nationalgallery.SubActivities;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.despkontopoulou.nationalgallery.PaintingView;
import com.despkontopoulou.nationalgallery.R;

public class FasianosActivity extends PaintingView {
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

        int[] imageIDs= new int[]{R.id.image1,R.id.image2,R.id.image3,R.id.image4};//get imageview ids array
        int[] textIDs= new int[]{R.id.desc1,R.id.desc2,R.id.desc3,R.id.desc4};//get textview ids array
        setPaintingsByPainter("Φασιανός",imageIDs,textIDs);
    }
}