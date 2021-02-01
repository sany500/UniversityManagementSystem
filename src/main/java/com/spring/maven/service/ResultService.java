/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.service;

import com.spring.maven.dao.impl.IResultDAO;
import com.spring.maven.model.Result;
import com.spring.maven.service.impl.IResultService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sany5
 */
@Service(value = "resultService")
public class ResultService implements IResultService {

    @Autowired
    IResultDAO resultDAO;

    @Override
    public Result save(HttpServletRequest request) {
        Result r = new Result();
        r.setSid(request.getParameter("sid"));
        r.setStudentName(request.getParameter("studentName"));
        r.setSemesterName(request.getParameter("semesterName"));
        r.setCourseName(request.getParameter("courseName"));
        r.setFacultyName(request.getParameter("facultyName"));

        double classTest1 = Double.parseDouble(request.getParameter("ct1"));
        double classTest2 = Double.parseDouble(request.getParameter("ct2"));
        double midTerm = Double.parseDouble(request.getParameter("midterm"));
        double finalMarks = Double.parseDouble(request.getParameter("final"));

        //All Calculation
        double classTest1persentage = (classTest1 / 50.00) * 100.00; //100 percent value

        double classTest1persentageTwo = (classTest1persentage / 100.00) * 10.00; ///10 percent value

        double classTest2persentage = (classTest1 / 50.00) * 100.00; //100 percent value

        double classTest2persentageTwo = (classTest1persentage / 100.00) * 10.00; ///10 percent value

        double midTermPersentage = (midTerm / 100.00) * 100.00;
        double midTermPersentageTwo = (midTermPersentage / 100.00) * 20.00;  ///20 percent

        double finalPersentage = (finalMarks / 100.00) * 100.00;
        double finalPersentageTwo = (finalPersentage / 100.00) * 60.00;

        double totalMarks = classTest1persentageTwo + classTest2persentageTwo + midTermPersentageTwo + finalPersentageTwo;
        
        
        //Grading System
        String grade;
        double cgpa;
        
        if(totalMarks>=80)
        {
            grade="A+";
            cgpa=4.00;
        }
        else if(totalMarks>=70 && totalMarks<80)
        {
           grade="A";
           cgpa=3.75;
        } 
        else if(totalMarks>=60 && totalMarks<70)
        {
            grade="B+";
            cgpa=3.50;
        }
        else if(totalMarks>=50 && totalMarks<60)
        {
            grade="B";
            cgpa=3.00;
        }
        else if(totalMarks>=45 && totalMarks<50)
        {
            grade="C";
            cgpa=2.25;
        }
        else if(totalMarks>=40 && totalMarks<45)
        {
            grade="D";
            cgpa=2.00;
        }
        else
        {
            grade="F";
            cgpa=0.00;
        }
        

        r.setCt1Marks(classTest1);
        r.setCt2Marks(classTest2);
        r.setMidtermMarks(midTerm);
        r.setFinalMarks(finalMarks);
        
        r.setTotalMarks(totalMarks);
        r.setCgpa(cgpa);
        r.setGrade(grade);

        System.out.println(totalMarks);
        System.out.println(grade);
        System.out.println(cgpa);

        resultDAO.save(r);
        return r;

    }

    @Override
    public Result update(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Result delete(int id) {
        return resultDAO.delete(id);
    }

    @Override
    public List<Result> getAll() {
        return resultDAO.getAll();
    }

    @Override
    public Result getById(int id) {
        return resultDAO.getById(id);
    }

}
