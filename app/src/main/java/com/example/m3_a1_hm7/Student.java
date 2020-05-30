package com.example.m3_a1_hm7;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Student implements Serializable, Comparable<Student> {
    private String name;
    private String numberPhone;
    private String group;
    private int id;
    private String note;

    public Student(String name, String numberPhone, String group) {
        this.name = name;
        this.numberPhone = numberPhone;
        this.group = group;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    @Override
    public String toString() {
        String s =
                "name: " + getName() + "\n" +
                "numberPhone: " + getNumberPhone() + "\n" +
                "group: " + getGroup() + "\n";
        if (note != null)
            s += "other: \n" + getNote();

        return s;
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.getName());
    }
}