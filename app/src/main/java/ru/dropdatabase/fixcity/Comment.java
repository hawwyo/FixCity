package ru.dropdatabase.fixcity;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;

public class Comment {
    private Author author;
    private String text;
    private LocalDate date;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Comment(Author author, String text) {
        this.author = author;
        this.text = text;

        date = LocalDate.now();
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
