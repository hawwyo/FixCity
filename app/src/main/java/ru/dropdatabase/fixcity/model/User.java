package ru.dropdatabase.fixcity.model;

import java.io.Serializable;

public class User implements Serializable {
    public String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
