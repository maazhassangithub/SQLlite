package com.example.myapplication;

import java.io.Serializable;

public class Student implements Serializable {

    private String studentId;
    private String studentName;
    private String courseName;

    public void setStudentId(String studentId){
        this.studentId = studentId;
    }
    public String getStudentId(){
        return studentId;
    }

    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
    public String getStudentName(){
        return studentName;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    public String getCourseName(){
        return courseName;
    }
}
