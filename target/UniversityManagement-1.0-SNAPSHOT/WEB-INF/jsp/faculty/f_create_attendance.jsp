




<%-- 
   Document   : admin
   Created on : Dec 29, 2020, 11:47:34 AM
   Author     : sany5
--%>

<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>




<div id="wrapper">
    <nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0">
        <div class="container-fluid d-flex flex-column p-0">
            <a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#">
                <div class="sidebar-brand-icon rotate-n-15"><i class="fas fa-chalkboard-teacher"></i></div>
                <div class="sidebar-brand-text mx-3"><span>Faculty</span></div>
            </a>
            <hr class="sidebar-divider my-0">
            <ul class="nav navbar-nav text-light" id="accordionSidebar">


                <li class="nav-item" role="presentation"><a class="nav-link " href="/fInfo"><i class="fas fa-address-card"></i><span>Faculty Info</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/fStudent"><i class="fas fa-graduation-cap"></i><span>Students</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link active" href="/fAttendance"><i class="fas fa-window-maximize"></i><span>Attendance</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/fResult"><i class="fas fa-window-maximize"></i><span>Result</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/fNotice"><i class="fas fa-flag"></i><span>Notice</span></a></li>
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
                            <div class="nav-item dropdown no-arrow"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#"><span class="d-none d-lg-inline mr-2 text-gray-600 small">${map.user.userName}</span><img class="border rounded-circle img-profile" src="/resources/vendor/css/assets/img/avatars/avatar1.jpeg"></a>
                                <div
                                    class="dropdown-menu shadow dropdown-menu-right animated--grow-in" role="menu"><a class="dropdown-item" role="presentation" href="/facultyProfile"><i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Profile</a> 
                                    <div class="dropdown-divider"></div><a class="dropdown-item" role="presentation" href="/"><i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Logout</a></div>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
            <div class="container-fluid">
                <div class="container my-4">


                    <p class="font-weight-bold"></p>

                    <div class="row">

                        <!-- Grid column -->
                        <div class="col-xl-12 mb-4 mb-xl-0">



                            <!-- Section: Live preview -->
                            <section>

                                <ul class="nav nav-tabs" id="myTab" role="tablist">
                                    <li class="nav-item waves-effect waves-light">
                                        <a class="nav-link" id="home-tab" data-toggle="tab" href="#insert" role="tab" aria-controls="home" aria-selected="false">Create Attendance</a>
                                    </li>
                                    <li class="nav-item waves-effect waves-light">
                                        <a class="nav-link" id="profile-tab"  href="/attendanceReportMain" role="tab" aria-controls="profile" aria-selected="false">View Attendance</a>
                                    </li>

                                </ul>
                                <div class="tab-content" id="myTabContent">
                                    <div class="tab-pane fade show active" id="insert" role="tabpanel" aria-labelledby="home-tab">

                                        <section>
                                            <div class="container-fluid">
                                                <div class="container mt-5">

                                                    <div><h4 class="p-0 m-0 pb-3 d-flex justify-content-center">Attendance Table</h4></div>
                                                    <hr/>



                                                    <div class="col-xl-6">
                                                        



                                                        <hr/>
                                                          
                                                    </div> 


                                                    
                                                    <form action="/attendanceSave" method="post">

                                                        <table class="table">
                                                            <thead>
                                                                <tr>
                                                                    <th scope="col">Select</th>
                                                                    <th scope="col">Student ID</th>
                                                                    <th scope="col">Name</th>
                                                                    <th scope="col">Semester</th>
                                                                    <th scope="col">Course</th>
                                                                    <th scope="col"> Taken By</th>
                                                                    <th scope="col">Action</th>

                                                                </tr>
                                                            </thead>

                                                            <tbody>

                                                                <c:forEach items="${map.asc}" var="stu">
                                                                    <tr>
                                                                        <td>
                                                                            <input type="checkbox" class="border" id="chkbox" name="attendanceStatus[]" value="${stu.id}">
                                                                        </td>
                                                                        <td>${stu.sid}</td>
                                                                        <td>${stu.name}</td>
                                                                        <td>${stu.semesterName}</td>
                                                                        <td>${stu.courseName}</td>
                                                                        <td>${map.user.userName}</td>
                                                                        
                                                                        <td>
                                                                            <input type="hidden" id="studentId" value="${stu.id}" name="studentId[]"/>
                                                                            <input type="hidden" id="studentsId" value="${stu.sid}" name="studentsId[]"/>


                                                                            <input type="hidden" id="studentName" value="${stu.name}" name="studentName[]"/>


                                                                            <input type="hidden" id="st1" name="status1[]" value=""/>
                                                                            <input type="hidden" id="studentSemester" value="${stu.semesterName}" name="studentSemester[]"/>
                                                                            <input type="hidden" id="courseName" value="${stu.courseName}" name="courseName[]"/>
                                                                            <input type="hidden" id="facultyName" value="${map.user.userName}" name="facultyName[]"/>



                                                                            <button type="button" class="btn btn-info" data-toggle="modal" data-target="#exampleModal" onclick="smsSend('${stu.name}')">Send SMS</button>
                                                                            <!-- Modal -->
                                                                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                                <div class="modal-dialog" role="document">
                                                                                    <div class="modal-content">
                                                                                        <div class="modal-header">
                                                                                            <h5 class="modal-title" id="exampleModalLabel">SMS Send Successful</h5>
                                                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                                                <span aria-hidden="true">&times;</span>
                                                                                            </button>
                                                                                        </div>
                                                                                        <div class="modal-body">
                                                                                            <h4>Sms Send to <p id="smsShow"></p></h4>
                                                                                        </div>
                                                                                        <div class="modal-footer">
                                                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <script>
                                                                                function smsSend(a){
                                                                                    $("#smsShow").text(a);
                                                                                   
                                                                                }
                                                                            </script>
                                                                        </td>
                                                                    </tr>



                                                                </c:forEach>
                                                            </tbody>

                                                        </table>

                                                        <div ><input type="submit" value="Submit"/></div>
                                                    </form>

<!--                                                    <script>
//                                                        $(document).ready(function () {
//                                                            $('#chkbox').click(function () {
//                                                                if ($(this).prop("checked") == true) {
//                                                                    $("#chkbox").val("Present");
//                                                                }
//                                                                else if ($(this).prop("checked") == false) {
//                                                                    $("#chkbox").val("Absent");
//                                                                }
//                                                            });
//                                                        });
//                                                        

                                                        $("#fCourse").change(function () {

                                                            $.ajax({
                                                                url: 'getCourse/' + this.value,
                                                                type: 'GET',
                                                                dataType: 'json',
                                                                success: function (data) {


                                                                    //$("#id").val(data.id);
                                                                    $("#courseName").val(data.courseName);

                                                                }



                                                            });

                                                        });


                                                        $("#fName").change(function () {

                                                            $.ajax({
                                                                url: 'getFaculty/' + this.value,
                                                                type: 'GET',
                                                                dataType: 'json',
                                                                success: function (data) {
                                                                    
                                                                    
                                                                    //$("#id").val(data.id);

                                                                    $("#facultyName").val(data.name);
                                                                }



                                                            });

                                                        });

                                                    </script>-->

                                                </div>
                                            </div>
                                        </section>

                                    </div>
                                    <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">

                                        <div class="container-fluid">
                                            <h3 class="text-dark mb-4">Team</h3>
                                            <div class="card shadow">
                                                <div class="card-header py-3">
                                                    <p class="text-primary m-0 font-weight-bold">Student Info</p>
                                                </div>
                                                <div class="card-body">
                                                    <div class="row">
                                                        <div class="col-md-6 text-nowrap">
                                                            <div id="dataTable_length" class="dataTables_length" aria-controls="dataTable"><label>Show&nbsp;<select class="form-control form-control-sm custom-select custom-select-sm"><option value="10" selected="">10</option><option value="25">25</option><option value="50">50</option><option value="100">100</option></select>&nbsp;</label></div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="text-md-right dataTables_filter" id="dataTable_filter"><label><input type="search" class="form-control form-control-sm" aria-controls="dataTable" placeholder="Search"></label></div>
                                                        </div>
                                                    </div>
                                                    <div class="table-responsive table mt-2" id="dataTable" role="grid" aria-describedby="dataTable_info">
                                                        <table class="table dataTable my-0" id="dataTable">
                                                            <thead>
                                                                <tr>
                                                                    <th>Student Id</th>
                                                                    <th>Student Name</th>

                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <td><img class="rounded-circle mr-2" width="30" height="30" src="assets/img/avatars/avatar1.jpeg">Airi Satou</td>
                                                                    <td>Accountant</td>

                                                                </tr>
                                                                <tr>
                                                                    <td><img class="rounded-circle mr-2" width="30" height="30" src="assets/img/avatars/avatar2.jpeg">Angelica Ramos</td>
                                                                    <td>Chief Executive Officer(CEO)</td>

                                                                </tr>

                                                            </tbody>
                                                            <tfoot>
                                                                <tr>
                                                                    <td><strong>Name</strong></td>
                                                                    <td><strong>Position</strong></td>

                                                                </tr>
                                                            </tfoot>
                                                        </table>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-6 align-self-center">
                                                            <p id="dataTable_info" class="dataTables_info" role="status" aria-live="polite">Showing 1 to 10 of 27</p>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <nav class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
                                                                <ul class="pagination">
                                                                    <li class="page-item disabled"><a class="page-link" href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                                                                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                                                    <li class="page-item"><a class="page-link" href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
                                                                </ul>
                                                            </nav>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>

                            </section>
                            <!-- Section: Live preview -->

                        </div>
                        <!-- Grid column -->

                        <!-- Modal Section -->
                        <div class="col-xl-6">

                            <!-- Button trigger modal -->






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




<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
