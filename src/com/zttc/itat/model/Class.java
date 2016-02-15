package com.zttc.itat.model;

import java.util.List;

/**
 * Created by �� on 2016/2/14.
 */
public class Class {
    private int id;
    private String name;
    private Teacher teacher;
    private List<Student> student;

    public Class() {
    }

    public Class(int id, String name, Teacher teacher, List<Student> student) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.student = student;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                ", student=" + student +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
