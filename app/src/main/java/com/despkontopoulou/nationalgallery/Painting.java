package com.despkontopoulou.nationalgallery;

public class Painting {

    private int id;
    private String title;
    private String painter;
    private String image_name;
    private String category;

    public Painting(){}
    public Painting(String title, String image_name, String painter,  String category){
        this.title=title;
        this.painter=painter;
        this.image_name=image_name;
        this.category=category;
    }
    public Painting(int id,String title, String image_name, String painter, String category){
        this.id=id;
        this.title=title;
        this.painter=painter;
        this.image_name=image_name;
        this.category=category;
    }
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPainter() {
        return painter;
    }

    public String getImage_name() {
        return image_name;
    }

    public String getCategory() {
        return category;
    }


}
