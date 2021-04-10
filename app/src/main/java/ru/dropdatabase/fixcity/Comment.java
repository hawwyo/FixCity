package ru.dropdatabase.fixcity;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;

public class Comment {
    private String author;
    private String text;
    private String date;

    public Comment() {
    }

    public Comment(String author, String text) {
        this.author = author;
        this.text = text;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            date = LocalDate.now().toString();
        }
    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getId() {
//        return id;
//    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
