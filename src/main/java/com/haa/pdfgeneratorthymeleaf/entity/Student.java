package com.haa.pdfgeneratorthymeleaf.entity;

import java.time.LocalDate;

public class Student {
    private Integer id;
    private String name;
    private String lastName;
    private LocalDate birthday;
    private String nationality;
    private String university;
    private Boolean active;

    public Student() {
    }

    public Student(Integer id, String name, String lastName, LocalDate birthday, String nationality, String university,
            Boolean active) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.nationality = nationality;
        this.university = university;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Student [active=" + active + ", birthday=" + birthday + ", id=" + id + ", lastName=" + lastName
                + ", name=" + name + ", nationality=" + nationality + ", university=" + university + "]";
    }

}