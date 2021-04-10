package ru.dropdatabase.fixcity;

import android.graphics.Bitmap;

import java.util.List;

public class Petition {

    Integer id;

    String author;
    Bitmap image;
    String title;
    int cntOfLikes;
    int cntOfComments;
    List<Comment> comments;

    public Petition() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;

    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
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

}