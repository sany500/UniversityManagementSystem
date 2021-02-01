/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spring.maven.dao.impl.IApprovedBookRequestDAO;
import com.spring.maven.dao.impl.IAssignFacultyCourseDAO;
import com.spring.maven.dao.impl.IAssignStudentCourseDAO;
import com.spring.maven.dao.impl.IAttendanceDAO;
import com.spring.maven.dao.impl.IFacultyDAO;
import com.spring.maven.dao.impl.IPaymentDAO;
import com.spring.maven.dao.impl.IResultDAO;
import com.spring.maven.dao.impl.ISemesterFeeDAO;
import com.spring.maven.dao.impl.IStudentDAO;
import com.spring.maven.dao.impl.IUserDAO;
import com.spring.maven.model.ApprovedBookRequest;
import com.spring.maven.model.AssignFacultyCourse;
import com.spring.maven.model.AssignStudentCourse;
import com.spring.maven.model.Attendance;
import com.spring.maven.model.Book;
import com.spring.maven.model.BookRequest;
import com.spring.maven.model.Course;
import com.spring.maven.model.Department;
import com.spring.maven.model.Faculty;
import com.spring.maven.model.Marks;
import com.spring.maven.model.Notice;
import com.spring.maven.model.Payment;
import com.spring.maven.model.Result;
import com.spring.maven.model.Semester;
import com.spring.maven.model.SemesterFee;
import com.spring.maven.model.Student;
import com.spring.maven.model.University;
import com.spring.maven.model.User;
import com.spring.maven.service.AssignStudentCourseService;
import com.spring.maven.service.impl.IAssignFacultyCourseService;
import com.spring.maven.service.impl.IAssignStudentCourseService;
import com.spring.maven.service.impl.IAttendanceService;
import com.spring.maven.service.impl.IBookRequestService;
import com.spring.maven.service.impl.IBookService;
import com.spring.maven.service.impl.ICourseService;
import com.spring.maven.service.impl.IDepartmentService;
import com.spring.maven.service.impl.IFacultyService;
import com.spring.maven.service.impl.IMarksService;
import com.spring.maven.service.impl.INoticeService;
import com.spring.maven.service.impl.IPaymentService;
import com.spring.maven.service.impl.IResultService;
import com.spring.maven.service.impl.ISemesterService;
import com.spring.maven.service.impl.IStudentService;
import com.spring.maven.service.impl.IUniversityService;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author B13
 */
@RestController
public class IndexController {

    @Autowired
    IUniversityService universityService;

    @Autowired
    IDepartmentService departmentService;

    @Autowired
    IStudentService studentService;

    @Autowired
    IFacultyService facultyService;

    @Autowired
    ISemesterService semesterService;

    @Autowired
    ICourseService courseService;

    @Autowired
    IAssignStudentCourseService assignStudentCourseService;

    @Autowired
    AssignStudentCourseService assignStudentCourseService2;

    @Autowired
    IAssignFacultyCourseService assignFacultyCourseService;

    @Autowired
    IAttendanceService attendanceService;

    @Autowired
    IResultService resultService;

    @Autowired
    IMarksService marksService;

    @Autowired
    INoticeService noticeService;

    @Autowired
    IBookService bookService;

    @Autowired
    IBookRequestService bookRequestService;

    @Autowired
    ISemesterFeeDAO semesterFeeDAO;

    @Autowired
    IPaymentService paymentService;

    @Autowired
    IPaymentDAO paymentDAO;

    @Autowired
    IAssignStudentCourseDAO assignStudentCourseDAO;

    @Autowired
    IStudentDAO studentDAO;

    @Autowired
    IUserDAO userDAO;

    @Autowired
    IAttendanceDAO attendanceDAO;

    @Autowired
    IResultDAO resultDAO;
    @Autowired
    IFacultyDAO facultyDAO;

    @Autowired
    IAssignFacultyCourseDAO assignFacultyCourseDAO;

    @Autowired
    IApprovedBookRequestDAO approvedBookRequestDAO;

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("/login1")
    public ModelAndView login() {

        return new ModelAndView("/admin/login");
    }

    @RequestMapping("/loginSuccess")
    public ModelAndView loginSuccess(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Map<String, Object> map = new HashMap<String, Object>();

        if (email.equalsIgnoreCase("admin@gmail.com") && password.equalsIgnoreCase("1234")) {
            return new ModelAndView("/admin/after_login");
        } else {
            map.put("status", "Incorrect Email or password");
            return new ModelAndView("/admin/login", "map", map);
        }

    }

    @RequestMapping("/university")
    public ModelAndView adminDashBoard() {

        return new ModelAndView("/admin/university");

    }

    @RequestMapping("/department")
    public ModelAndView department() {
        List<University> uList = universityService.getAll();
        List<Department> dList = departmentService.getAll();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uList", uList);
        map.put("dList", dList);

        return new ModelAndView("/admin/department", "map", map);
    }

    @RequestMapping("/semister")
    public ModelAndView semister() {

        List<Department> departments = departmentService.getAll();
        List<Semester> semesters = semesterService.getAll();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("departments", departments);
        map.put("semesters", semesters);

        return new ModelAndView("/admin/semister", "map", map);

    }

    @RequestMapping("/courses")
    public ModelAndView courses() {
        List<Semester> sm = semesterService.getAll();
        List<Course> courses = courseService.getAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sm", sm);
        map.put("courses", courses);
        return new ModelAndView("/admin/courses", "map", map);
    }

    @RequestMapping("/students")
    public ModelAndView students() {
        return new ModelAndView("/admin/students");
    }

    @RequestMapping("/paymentView")
    public ModelAndView paymentView() {
        List<Payment> payments = paymentService.getAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("payments", payments);
        return new ModelAndView("/admin/payment_view", "map", map);
    }

    @RequestMapping("/faculty")
    public ModelAndView faculty() {
        return new ModelAndView("/admin/faculty");
    }

    @RequestMapping("/library")
    public ModelAndView library() {
        List<BookRequest> bookRequests = bookRequestService.getAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("books", bookRequests);
        return new ModelAndView("/admin/library", "map", map);
    }

    @RequestMapping("/notice")
    public ModelAndView notice() {
        List<Notice> notice = noticeService.getAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("notice", notice);
        return new ModelAndView("/admin/notice", "map", map);
    }

    @RequestMapping("/assignCourse")
    public ModelAndView assignCourse() {
        List<Student> students = studentService.getAll();
        List<Semester> semesters = semesterService.getAll();
        List<Course> courses = courseService.getAll();
        List<Faculty> facultys = facultyService.getAll();
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("students", students);
        map.put("semesters", semesters);
        map.put("courses", courses);
        map.put("facultys", facultys);
        return new ModelAndView("/admin/assign_course", "map", map);
    }

    @RequestMapping("/admitCard")
    public ModelAndView admitCard() {

        return new ModelAndView("/admin/admit_card_search");
    }

    @RequestMapping("/getAdmitCard")
    public ModelAndView getAdmitCard(HttpServletRequest request) {
        int sid = Integer.parseInt(request.getParameter("sid"));
        System.out.println(sid);
        List<AssignStudentCourse> asc = assignStudentCourseDAO.getStudentCourseById(sid);
        Student st = studentDAO.getStudentbySId(sid);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("courses", asc);
        map.put("st", st);
        return new ModelAndView("/admin/admit_card", "map", map);
    }

    @RequestMapping("/reports")
    public ModelAndView reports() {

        List<Student> s = studentService.getAll();
        List<Faculty> f = facultyService.getAll();
        List<Attendance> attendances = attendanceService.getAll();
        List<Book> books = bookService.getAll();
        List<Payment> payments = paymentService.getAll();
        List<Result> results = resultService.getAll();
        List<Notice> notice = noticeService.getAll();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("students", s);
        map.put("faculties", f);
        map.put("attendances", attendances);
        map.put("books", books);
        map.put("payments", payments);
        map.put("results", results);
        map.put("notice", notice);
        return new ModelAndView("/admin/report", "map", map);
    }

    //Faculty 
    @RequestMapping("/fLogin")
    public ModelAndView fLogin() {
        return new ModelAndView("/faculty/f_login");
    }

    @RequestMapping("/fStudent")
    public ModelAndView fStudent(ModelMap model, Principal principal) {
        String loggedInUserName = principal.getName();
        User u = userDAO.getUserByUserName(loggedInUserName);
        List<Student> s = studentService.getAll();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("students", s);
        map.put("user", u);

        return new ModelAndView("/faculty/f_students", "map", map);

    }

    @RequestMapping("/fNotice")
    public ModelAndView fNotice(ModelMap model, Principal principal) {
        String loggedInUserName = principal.getName();
        User u = userDAO.getUserByUserName(loggedInUserName);
        List<Notice> notice = noticeService.getAllByFacultyPrivilege();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("notice", notice);
        map.put("user", u);
        return new ModelAndView("/faculty/f_notice", "map", map);
    }

    @RequestMapping("/fInfo")
    public ModelAndView fInfo(ModelMap model, Principal principal) {
        String loggedInUserName = principal.getName();
        User u = userDAO.getUserByUserName(loggedInUserName);
        List<Notice> notice = noticeService.getAllByFacultyPrivilege();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("notice", notice);
        map.put("user", u);
        return new ModelAndView("/faculty/f_info", "map", map);

    }
    //Result Making Start

    @RequestMapping("/fResult")
    public ModelAndView fResult(ModelMap model, Principal principal) {

        String loggedInUserName = principal.getName();
        User u = userDAO.getUserByUserName(loggedInUserName);

        int fid = Integer.parseInt(u.getUserId());
        List<AssignFacultyCourse> afcList = assignFacultyCourseDAO.getAllFacultyCourseById(fid);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("afc", afcList);
        map.put("user", u);
        return new ModelAndView("/faculty/f_result", "map", map);
    }

    ////////Query////////
    @RequestMapping(value = "/createResult")
    public ModelAndView createResult(HttpServletRequest request) {
        String uname = request.getUserPrincipal().getName();
        User u = userDAO.getUserByUserName(uname);

        String courseName = request.getParameter("courseName");
        String semesterName = request.getParameter("semesterName");

        List<AssignStudentCourse> asc = assignStudentCourseService2.getAllbyCourse(courseName, semesterName);
        List<Course> courses = courseService.getAll();
        List<Semester> semesters = semesterService.getAll();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("asc", asc);
        map.put("courses", courses);
        map.put("semesters", semesters);
        map.put("user", u);

        return new ModelAndView("/faculty/f_create_result", "map", map);

    }

    @RequestMapping("/resultProcess")
    public ModelAndView resultProcess(ModelMap model, Principal principal) {
        String loggedInUserName = principal.getName();
        User u = userDAO.getUserByUserName(loggedInUserName);
        List<Result> results = resultService.getAll();
        List<Marks> marks = marksService.getAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("results", results);
        map.put("marks", marks);
        map.put("user", u);

        return new ModelAndView("/faculty/result_process", "map", map);
    }

    ////////Query////////
    @RequestMapping(value = "/createAttendance")
    public ModelAndView createAttendance(HttpServletRequest request) {
        String uname = request.getUserPrincipal().getName();
        User u = userDAO.getUserByUserName(uname);

        List<Course> courses = courseService.getAll();
        List<Faculty> facultys = facultyService.getAll();
        String courseName = request.getParameter("courseName");
        String semesterName = request.getParameter("semesterName");

        List<AssignStudentCourse> asc = assignStudentCourseService2.getAllbyCourse(courseName, semesterName);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("asc", asc);
        map.put("user", u);

        return new ModelAndView("/faculty/f_create_attendance", "map", map);

    }

    //Result Making end
    //Attendance Making Start
    @RequestMapping("/fAttendance")
    public ModelAndView fAttendance(ModelMap model, Principal principal) {
        String loggedInUserName = principal.getName();
        User u = userDAO.getUserByUserName(loggedInUserName);
        int fid = Integer.parseInt(u.getUserId());
        List<AssignFacultyCourse> afcList = assignFacultyCourseDAO.getAllFacultyCourseById(fid);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("afc", afcList);
        map.put("user", u);

        return new ModelAndView("/faculty/f_attendanceMain", "map", map);
    }

    // for Student
    @RequestMapping("/sLogin")
    public ModelAndView sLogin() {
        return new ModelAndView("/student/s_login");
    }

    //Student Login Through Id
    @RequestMapping("/sInfo")
    public ModelAndView sInfo(HttpServletRequest request) {
        String uname = request.getUserPrincipal().getName();

        User u = userDAO.getUserByUserName(uname);

        List<Notice> notice = noticeService.getAllByStudentPrivilege();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("notice", notice);
        map.put("user", u);
        //map.put("asc", asc);
        return new ModelAndView("/student/s_info", "map", map);
    }

    @RequestMapping("/sLibrary")
    public ModelAndView sLibrary(ModelMap model, Principal principal) {
        List<Book> books = bookService.getAll();
        String loggedInUserName = principal.getName();

        User u = userDAO.getUserByUserName(loggedInUserName);
        List<ApprovedBookRequest> abr= approvedBookRequestDAO.getApprovedBookRequestBySId(Integer.parseInt(u.getUserId()));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("books", books);
        map.put("user", u);
        map.put("abr", abr);
        return new ModelAndView("/student/s_library", "map", map);
    }

    @RequestMapping("/sNotice")
    public ModelAndView sNotice(ModelMap model, Principal principal) {
        String loggedInUserName = principal.getName();
        User u = userDAO.getUserByUserName(loggedInUserName);
        List<Notice> notice = noticeService.getAllByStudentPrivilege();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("notice", notice);
        map.put("user", u);
        return new ModelAndView("/student/s_notice", "map", map);

    }

    @RequestMapping("/sResult")
    public ModelAndView sResult(ModelMap model, Principal principal) {
        String loggedInUserName = principal.getName();
        User u = userDAO.getUserByUserName(loggedInUserName);

        List<Result> rlist = resultDAO.getResultByUserId(u.getUserId());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", u);
        map.put("rlist", rlist);
        for (Result rlist1 : rlist) {
            System.out.println(rlist1.getStudentName());
        }
        System.out.println(u.getUserName());

        return new ModelAndView("/student/s_result", "map", map);
    }

    @RequestMapping("/sAttendance")
    public ModelAndView sAttendance(ModelMap model, Principal principal) {
        String uname = principal.getName();
        User u = userDAO.getUserByUserName(uname);
        List<Attendance> attendances = attendanceDAO.getAttendancebyUserId(u.getUserId());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", u);
        map.put("attendances", attendances);

        return new ModelAndView("/student/s_attendance", "map", map);
    }

    @RequestMapping("/sSemesterFee")
    public ModelAndView sSemesterFee(ModelMap model, Principal principal) {
        String uname = principal.getName();
        User u = userDAO.getUserByUserName(uname);
        List<Semester> semesters = semesterService.getAll();
        List<AssignStudentCourse> asc = assignStudentCourseService.getAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("semesters", semesters);
        map.put("asc", asc);
        map.put("user", u);
        return new ModelAndView("/student/semester_fee_main", "map", map);
    }

    @RequestMapping("/sCreatePayment")
    public ModelAndView sCreatePayment(HttpServletRequest request) {
        String uname = request.getUserPrincipal().getName();
        User u = userDAO.getUserByUserName(uname);

        String semester = request.getParameter("sm");
        String studentId = request.getParameter("st");

        Map<String, Object> map = new HashMap<String, Object>();
        List<AssignStudentCourse> asc = assignStudentCourseService.getAll();
        List<Semester> semesters = semesterService.getAll();
        SemesterFee sf = semesterFeeDAO.getById(1);
        map.put("semesters", semesters);
        map.put("sf", sf);
        map.put("asc", asc);
        map.put("user", u);

        Payment p = paymentDAO.getAllById(semester, studentId);
        map.put("payment", p);
        if (null != p) {
            System.out.println("else............................");
            return new ModelAndView("/student/allready_paid", "map", map);
        } else {
            System.out.println("if............................");

            return new ModelAndView("/student/create_payment", "map", map);
        }

    }

    @RequestMapping("/sAdmitCardGenerate")
    public ModelAndView sAdmitCardGenerate(ModelMap model, Principal principal) {
        String uname = principal.getName();
        User u = userDAO.getUserByUserName(uname);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("user", u);
        return new ModelAndView("/student/s_admit_card_search", "map", map);
    }

    @RequestMapping("/studentProfile")
    public ModelAndView studentProfile(Principal principal) {
        String uname = principal.getName();
        User u = userDAO.getUserByUserName(uname);
        int sid = Integer.parseInt(u.getUserId());
        List<AssignStudentCourse> ascList = assignStudentCourseDAO.getStudentCourseById(sid);
        Student student = studentDAO.getStudentbySId(sid);
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("user", u);
        map.put("ascList", ascList);
        map.put("student", student);
        return new ModelAndView("/student/user_profile", "map", map);
    }

    @RequestMapping("/facultyProfile")
    public ModelAndView facultyProfile(Principal principal) {
        String uname = principal.getName();
        User u = userDAO.getUserByUserName(uname);
        int fid = Integer.parseInt(u.getUserId());

        List<AssignFacultyCourse> afcList = assignFacultyCourseDAO.getAllFacultyCourseById(fid);
        Faculty faculty = facultyDAO.getFacultyByFid(fid);
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("user", u);
        map.put("afcList", afcList);
        map.put("faculty", faculty);
        return new ModelAndView("/faculty/user_profile", "map", map);
    }

    @RequestMapping(value = "/getUniversity/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllUniversity(@PathVariable("id") int id) {

        System.out.println("...................... " + id);
        GsonBuilder gson = new GsonBuilder();
        Gson g = gson.create();
        University u = universityService.getById(id);
        return g.toJson(u);
    }

    @RequestMapping(value = "/getAllAssignStudent/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllAssignStudent(@PathVariable("id") int id) {

        System.out.println("...................... " + id);
        GsonBuilder gson = new GsonBuilder();
        Gson g = gson.create();
        AssignStudentCourse asc = assignStudentCourseService.getById(id);
        return g.toJson(asc);
    }

    @RequestMapping(value = "/getAllAssignFaculty/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllAssignFaculty(@PathVariable("id") int id) {

        System.out.println("...................... " + id);
        GsonBuilder gson = new GsonBuilder();
        Gson g = gson.create();
        AssignFacultyCourse afc = assignFacultyCourseService.getById(id);
        return g.toJson(afc);
    }

}
