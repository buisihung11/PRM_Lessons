package com.example.demo_navigation.dtos;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class StudentDTO implements Serializable {
    private String id, name;
    private float mark;

    public StudentDTO(String id, String name, float mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    @NonNull
    @Override
    public String toString() {
        return id + "-" + name + "-" + mark;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getMark() {
        return mark;
    }
}
