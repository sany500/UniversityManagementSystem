/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author sany5
 */
@Entity
public class Result {
    @Id
    private int id;
    private String sid;
    private String studentName;
    private String semesterName;
    private String courseName;
    private String facultyName;
    private Double ct1Marks;
    private Double ct2Marks;
    private Double midtermMarks;
    private Double cgpa;
    private String grade;
    private Double finalMarks;
    private Double totalMarks;

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Double totalMarks) {
        this.totalMarks = totalMarks;
    }
    

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getCt1Marks() {
        return ct1Marks;
    }

    public void setCt1Marks(Double ct1Marks) {
        this.ct1Marks = ct1Marks;
    }

    public Double getCt2Marks() {
        return ct2Marks;
    }

    public void setCt2Marks(Double ct2Marks) {
        this.ct2Marks = ct2Marks;
    }

    public Double getMidtermMarks() {
        return midtermMarks;
    }

    public void setMidtermMarks(Double midtermMarks) {
        this.midtermMarks = midtermMarks;
    }

    public Double getFinalMarks() {
        return finalMarks;
    }

    public void setFinalMarks(Double finalMarks) {
        this.finalMarks = finalMarks;
    }

   
    
    
    
}
