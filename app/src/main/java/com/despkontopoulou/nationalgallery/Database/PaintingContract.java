package com.despkontopoulou.nationalgallery.Database;

import android.provider.BaseColumns;

public final class PaintingContract {
    private PaintingContract(){}
    public static class PaintingEntry implements BaseColumns {
        public static final String TABLE_NAME = "paintings";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_IMAGE_NAME = "image_name";
        public static final String COLUMN_NAME_PAINTER = "painter";
        public static final String COLUMN_NAME_CATEGORY = "category";

    }

}
