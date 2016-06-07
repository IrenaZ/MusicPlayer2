package com.example.re3.musictext;


import android.graphics.Bitmap;
import android.net.Uri;

/**
 * Created by re3 on 27.05.16.
 */
public class Music {


   // private String name; // название

    //private Bitmap album_pic; // ресурс
    private String path; //путь

    // private Uri mus_Uri;
private  int id;

    public Music (){}
    public Music(int id, String path){
        this.id=id;
        this.path=path;

    }

    public Music( String path){
              this.path=path;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

/*
    public Uri getMus_Uri() {
        return mus_Uri;
    }

    public void setMus_Uri(Uri mus_Uri) {
        this.mus_Uri = mus_Uri;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getAlbum_pic() {
        return album_pic;
    }

    public void setAlbumpic(Bitmap album_pic) {
        this.album_pic = album_pic;
    }
*/
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
