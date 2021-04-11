package ru.dropdatabase.fixcity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;


import java.io.ByteArrayOutputStream;

import java.util.LinkedList;

import java.util.List;

public class Petition {
    Integer id;
    String author;
    String image;
    String title;
    int cntOfLikes;
    int cntOfComments;
    String description;
    List<Comment> comments;


    public Petition() {}

    public Petition(String author, String image, String title, String description) {
        this.author = author;
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public Petition(String author, String image, String title) {
        this.author = author;
        this.image = image;
        this.title = title;
        this.cntOfLikes = 0;
        this.cntOfComments = 0;
        this.comments = new LinkedList<>();

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getImage() {
        return image;
//        return convert(image);
    }
    public boolean imageIsNull() {
        return image == null;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCntOfLikes() {
        return cntOfLikes;
    }

    public void setCntOfLikes(int cntOfLikes) {
        this.cntOfLikes = cntOfLikes;
    }

    public int getCntOfComments() {
        return cntOfComments;
    }

    public void setCntOfComments(int cntOfComments) {
        this.cntOfComments = cntOfComments;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public static Bitmap convert(String base64Str) throws IllegalArgumentException
    {
        byte[] decodedBytes = Base64.decode(
                base64Str.substring(base64Str.indexOf(",")  + 1),
                Base64.DEFAULT
        );

        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }

    public static String convert(Bitmap bitmap)
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 50, outputStream);

        return Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT);
    }
}