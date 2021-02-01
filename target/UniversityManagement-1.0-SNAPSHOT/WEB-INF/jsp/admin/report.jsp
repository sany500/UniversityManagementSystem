




<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
   Document   : admin
   Created on : Dec 29, 2020, 11:47:34 AM
   Author     : sany5
--%>

<jsp:include page="/WEB-INF/jsp/common/header.jsp" />



<div id="wrapper">
    <nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0">
        <div class="container-fluid d-flex flex-column p-0">
            <a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#">
                <div class="sidebar-brand-icon rotate-n-15"><i class="fas fa-user-shield"></i></div>
                <div class="sidebar-brand-text mx-3"><span>Admin</span></div>
            </a>
            <hr class="sidebar-divider my-0">
            <ul class="nav navbar-nav text-light" id="accordionSidebar">

                <li class="nav-item" role="presentation"><a class="nav-link " href="/university"><i class="fas fa-university"></i><span>University</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/department"><i class="fas fa-address-card"></i><span>Department</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/semister"><i class="fas fa-window-maximize"></i><span>Semester</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/courses"><i class="fas fa-window-maximize"></i><span>Courses</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/students"><i class="fas fa-graduation-cap"></i><span>Students</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/faculty"><i class="fas fa-window-maximize"></i><span>Faculty</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/library"><i class="fas fa-book"></i><span>Library</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/notice"><i class="fas fa-flag"></i><span>Notice</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/assignCourse"><i class="fab fa-adn"></i><span>Assign Courses</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/paymentView"><i class="fab fa-adn"></i><span>Payment</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/admitCard"><i class="fab fa-adn"></i><span>Admit Card</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link active" href="/reports"><i class="fas fa-receipt"></i><span>Reports</span></a></li>

            </ul>
            <div class="text-center d-none d-md-inline"><button class="btn rounded-circle border-0" id="sidebarToggle" type="button"></button></div>
        </div>
    </nav>
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
            <nav class="navbar navbar-light navbar-expand bg-white shadow mb-4 topbar static-top">
                <div class="container-fluid"><button class="btn btn-link d-md-none rounded-circle mr-3" id="sidebarToggleTop" type="button"><i class="fas fa-bars"></i></button>

                    <ul class="nav navbar-nav flex-nowrap ml-auto">



                        <div class="d-none d-sm-block topbar-divider"></div>
                        <li class="nav-item dropdown no-arrow" role="presentation">
                            <div class="nav-item dropdown no-arrow"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#"><span class="d-none d-lg-inline mr-2 text-gray-600 small">Admin</span><img class="border rounded-circle img-profile" src="/resources/vendor/css/assets/img/avatars/avatar1.jpeg"></a>
                                <div
                                    class="dropdown-menu shadow dropdown-menu-right animated--grow-in" role="menu"><a class="dropdown-item" role="presentation" href="#"><i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Profile</a><a class="dropdown-item" role="presentation" href="#"><i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Settings</a>
                                    <a
                                        class="dropdown-item" role="presentation" href="#"><i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Activity log</a>
                                    <div class="dropdown-divider"></div><a class="dropdown-item" role="presentation" href="/"><i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Logout</a></div>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
            <div class="container-fluid">
                <div class="container my-4">


                    <p class="font-weight-bold">All Reports</p>

                    <div class="row">

                        <!-- Grid column -->
                        <div class="col-xl-12 mb-4 mb-xl-0">



                            <!-- Section: Live preview -->
                            <section>

                                <ul class="nav nav-tabs" id="myTab" role="tablist">
                                    <li class="nav-item waves-effect waves-light">
                                        <a class="nav-link" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="false"> Students Report</a>
                                    </li>
                                    <li class="nav-item waves-effect waves-light">
                                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Faculties Report</a>
                                    </li>

                                    <li class="nav-item waves-effect waves-light">
                                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#report3" role="tab" aria-controls="profile" aria-selected="false">Attendance Report</a>
                                    </li>

                                    <li class="nav-item waves-effect waves-light">
                                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#report4" role="tab" aria-controls="profile" aria-selected="false">Book Report</a>
                                    </li>
                                    <li class="nav-item waves-effect waves-light">
                                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#report5" role="tab" aria-controls="profile" aria-selected="false">Payment Report</a>
                                    </li>
                                    <li class="nav-item waves-effect waves-light">
                                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#report6" role="tab" aria-controls="profile" aria-selected="false">Result Report</a>
                                    </li>
                                    <li class="nav-item waves-effect waves-light">
                                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#report7" role="tab" aria-controls="profile" aria-selected="false">Notice Report</a>
                                    </li>

                                </ul>
                                <div class="tab-content" id="myTabContent">
                                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">


                                        <!--  Report 1-->
                                        <section>
                                            <div class="d-flex justify-content-center mt-2"><h3>Student Report</h3></div>
                                            <table id="studentTable" class="display nowrap" style="width:100%">
                                                <thead >

                                                    <tr>
                                                        <th> Id</th>
                                                        <th> Name</th>
                                                        <th> Email</th>
                                                        <th> Gender</th>
                                                        <th> Phone</th>
                                                        <th> Address</th>
                                                        <th> Father's Name</th>
                                                        <th>Mother's Name</th>
                                                        <th>Date Of Birth</th>
                                                        <th>Religion</th>
                                                        <th>Blood Group</th>
                                                        <th style="padding: 35px">Action</th>


                                                    </tr>

                                                </thead>
                                                <tbody>

                                                    <c:forEach items="${map.students}" var="stu">

                                                        <tr>

                                                            <td>${stu.sid}</td>
                                                            <td>${stu.name}</td>
                                                            <td>${stu.email}</td>
                                                            <td>${stu.gender}</td>
                                                            <td>${stu.phone}</td>
                                                            <td>${stu.address}</td>
                                                            <td>${stu.fName}</td>
                                                            <td>${stu.mName}</td>
                                                            <td>${stu.dob}</td>
                                                            <td>${stu.religion}</td>
                                                            <td>${stu.bloodGroup}</td>
                                                            <td><a href="/sEdit/${stu.id}" ><button class="btn btn-info mb-1 btn-sm"><i class="fa fa-edit" aria-hidden="true"></i></button></a>  <a href="/sDelete/${stu.id}" ><button class="btn btn-danger btn-sm"><i class="fa fa-trash" aria-hidden="true"></i></button></a></td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>


                                        </section>

                                    </div>

                                    <!--  Report 2-->
                                    <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">

                                        <section>
                                            <div class="d-flex justify-content-center mt-2"><h3>Faculty Report</h3></div>
                                            <table  id="facultyReport" class="display nowrap" style="width:100%">
                                                <thead>
                                                    <tr>
                                                        <th> Id</th>
                                                        <th> Name</th>
                                                        <th> Email</th>
                                                        <th> Gender</th>
                                                        <th> Phone</th>
                                                        <th> Address</th>
                                                        <th> Designation</th>
                                                        <th>DOB</th>
                                                        <th>Religion</th>
                                                        <th>Blood Group</th>



                                                    </tr>
                                                </thead>
                                                <tbody>

                                                    <c:forEach items="${map.faculties}" var="fa">

                                                        <tr>

                                                            <td>${fa.fid}</td>
                                                            <td>${fa.name}</td>
                                                            <td>${fa.email}</td>
                                                            <td>${fa.gender}</td>
                                                            <td>${fa.phone}</td>
                                                            <td>${fa.address}</td>
                                                            <td>${fa.designation}</td>
                                                            <td>${fa.dob}</td>
                                                            <td>${fa.religion}</td>
                                                            <td>${fa.bloodGroup}</td>


                                                        </tr>
                                                    </c:forEach>


                                                </tbody>

                                            </table>

                                        </section>

                                    </div>


                                    <!--  Report 3-->
                                    <div class="tab-pane fade" id="report3" role="tabpanel" aria-labelledby="profile-tab">

                                        <section>
                                            <div class="d-flex justify-content-center mt-2"><h3>Attendance Report</h3></div>
                                            <table class="display nowrap" style="width:100%" id="Attendance">
                                                <thead>
                                                    <tr>
                                                        <th> Id</th>
                                                        <th> Name</th>
                                                        <th> Semester</th>
                                                        <th> Status</th>
                                                        <th> Date</th>
                                                        <th>Attendance Taken by</th>
                                                        <th>Subject</th>
                                                    </tr>
                                                </thead>
                                                <tbody>

                                                    <c:forEach items="${map.attendances}" var="at">

                                                        <tr>
                                                            <td>${at.studentId}</td>
                                                            <td>${at.studentName}</td>
                                                            <td>${at.studentSemester}</td>
                                                            <td style="color: #ca2819">${at.status}</td>
                                                            <td>${at.date}</td>
                                                            <td>${at.facultyName}</td>
                                                            <td>${at.courseName}</td>
                                                        </tr>
                                                    </c:forEach>


                                                </tbody>

                                            </table>

                                        </section>

                                    </div>


                                    <!--  Report 4-->
                                    <div class="tab-pane fade" id="report4" role="tabpanel" aria-labelledby="profile-tab">

                                        <section>
                                            <div class="d-flex justify-content-center mt-2"><h3>Book Report</h3></div>
                                            <table class="display nowrap" style="width:100%" id="bookReport">
                                                <thead class="bill-header cs">
                                                    <tr>
                                                        <th> Book Code</th>
                                                        <th> Book Name</th>
                                                        <th> Author</th>
                                                        <th> Genre</th>
                                                        <th> Publisher</th>
                                                        <th>Quantity</th>
                                                        <th>Edition</th>
                                                        <th>Price</th>





                                                    </tr>
                                                </thead>
                                                <tbody>

                                                    <c:forEach items="${map.books}" var="book">

                                                        <tr>

                                                            <td>${book.bookCode}</td>
                                                            <td>${book.bookName}</td>
                                                            <td>${book.author}</td>
                                                            <td >${book.genre}</td>
                                                            <td>${book.publisher}</td>
                                                            <td>${book.quantity}</td>
                                                            <td>${book.edition}</td>
                                                            <td>${book.price}</td>



                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>


                                        </section>

                                    </div>

                                    <!--                                    Report 5-->
                                    <div class="tab-pane fade" id="report5" role="tabpanel" aria-labelledby="profile-tab">

                                        <section>
                                            <div class="d-flex justify-content-center mt-2"><h3>Payments </h3></div>
                                            <table class="display nowrap" style="width:100%" id="payment">
                                                <thead class="bill-header cs">
                                                    <tr>
                                                        <th> Student Name</th>
                                                        <th> Student Id</th>
                                                        <th> Semester</th>
                                                        <th> Payment Date</th>
                                                        <th> Payment Method</th>
                                                        <th> Payment No.</th>
                                                        <th>Transaction ID</th>
                                                        <th>Total Payment(Bdt)</th>
                                                    </tr>
                                                </thead>
                                                <tbody>

                                                    <c:forEach items="${map.payments}" var="pay">

                                                        <tr>

                                                            <td>${pay.studentName}</td>
                                                            <td>${pay.studentId}</td>
                                                            <td>${pay.semesterName}</td>
                                                            <td >${pay.paymentDate}</td>
                                                            <td>${pay.paymentMethod}</td>
                                                            <td>${pay.mobileNo}</td>
                                                            <td>${pay.trId}</td>
                                                            <td>${pay.totalFee} /-</td>




                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>


                                        </section>

                                    </div>


                                    <!--                                    Report 6-->
                                    <div class="tab-pane fade" id="report6" role="tabpanel" aria-labelledby="profile-tab">

                                        <section>
                                            <div class="d-flex justify-content-center mt-2"><h3>Results </h3></div>
                                            <table class="display nowrap" style="width:100%" id="result">
                                                <thead class="bill-header cs">
                                                    <tr>
                                                        <th> Id</th>
                                                        <th> Name</th>
                                                        <th> Semester</th>
                                                        <th> Course</th>
                                                        <th> Faculty</th>
                                                        <th>Class Test1(50*10%)</th>
                                                        <th>Class Test2(50*10%)</th>
                                                        <th>Mid Term (100*20%)</th>
                                                        <th>Final Marks(100*60%)</th>
                                                        <th>Total Average</th>
                                                        <th>CGPA</th>
                                                        <th>Grade</th>




                                                    </tr>
                                                </thead>
                                                <tbody>

                                                    <c:forEach items="${map.results}" var="r">

                                                        <tr>

                                                            <td>${r.sid}</td>
                                                            <td>${r.studentName}</td>
                                                            <td>${r.semesterName}</td>
                                                            <td>${r.courseName}</td>
                                                            <td>${r.facultyName}</td>
                                                            <td>${r.ct1Marks}</td>
                                                            <td>${r.ct2Marks}</td>
                                                            <td>${r.midtermMarks}</td>
                                                            <td>${r.finalMarks}</td>
                                                            <td>${r.totalMarks}</td>

                                                            <td>${r.cgpa}</td>
                                                            <td>${r.grade}</td>


                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>


                                        </section>

                                    </div>


                                    <!--                                    Report 7-->
                                    <div class="tab-pane fade" id="report7" role="tabpanel" aria-labelledby="profile-tab">

                                        <section>
                                            <div class="d-flex justify-content-center mt-2"><h3>Notice</h3></div>
                                            <table class="display nowrap" style="width:100%" id="notice">
                                                <thead>
                                                    <tr>
                                                        <th>ID</th>
                                                        <th>Privilege</th>
                                                        <th>Notice Header</th>
                                                        <th>Notice Body</th>

                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${map.notice}" var="n">
                                                        <tr>
                                                            <td>${n.id}</td>
                                                            <td>${n.privilege}</td>
                                                            <td>${n.noticeHeader}</td>
                                                            <td>${n.noticeBody}</td>
                                                            
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>

                                            </table>

                                        </section>

                                    </div>

                                </div>

                            </section>
                            <!-- Section: Live preview -->

                        </div>
                        <!-- Grid column -->

                        <!-- Grid column -->
                        <div class="col-xl-6">





                        </div>
                        <!-- Grid column -->

                    </div>

                </div>
            </div>
        </div>
        <footer class="bg-white sticky-footer">
            <div class="container my-auto">
                <div class="text-center my-auto copyright"><span>Copyright © Mezbaur Rahman 2020-2021</span></div>
            </div>
        </footer>
    </div><a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a></div>


<script>
    $(document).ready(function () {
        $('#studentTable').DataTable({
            "scrollX": true
        });

        $('#Attendance').DataTable({
            "scrollX": true
        });

        $('#facultyReport').DataTable({
            "scrollX": true
        });
        $('#bookReport').DataTable({
            "scrollX": true
        });
        $('#payment').DataTable({
            "scrollX": true
        });
        $('#result').DataTable({
            "scrollX": true
        });
        $('#notice').DataTable({
            "scrollX": true
        });
    });
</script>

<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
