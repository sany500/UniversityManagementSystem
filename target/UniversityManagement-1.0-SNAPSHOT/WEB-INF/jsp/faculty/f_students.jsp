




<%-- 
   Document   : admin
   Created on : Dec 29, 2020, 11:47:34 AM
   Author     : sany5
--%>

<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



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
                <li class="nav-item" role="presentation"><a class="nav-link active" href="/fStudent"><i class="fas fa-graduation-cap"></i><span>Students</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/fAttendance"><i class="fas fa-window-maximize"></i><span>Attendance</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/fResult"><i class="fas fa-window-maximize"></i><span>Result</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link active" href="/fNotice"><i class="fas fa-flag"></i><span>Notice</span></a></li>
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

                               <div class="container-fluid">
                                <h3 class="text-dark mb-4">All Students</h3>
                                <div class="card shadow">
                                    <div class="card-header py-3">
                                        <p class="text-primary m-0 font-weight-bold">Students Info</p>
                                    </div>
                                    <div class="container shadow" style="background-color: #ffffff;margin-top: 0px;">
                                        <div class="row no-gutters text-left justify-content-center align-items-center" style="height: 100%;">
                                            <div class="col-md-12 search-table-col" style="margin-top: 0px;">
                                                <div class="form-group pull-right col-lg-4"><input type="text" class="search form-control" placeholder="Search by typing here.."></div><span class="counter pull-right" style="color: rgb(88,82,82);font-size: 22px;"></span>
                                                <div class="table-responsive table-bordered table table-hover table-bordered results"
                                                     style="width: 100%;">
                                                    <table class="table table-bordered table-hover">
                                                        <thead class="bill-header cs">
                                                            <tr>
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
                                                                


                                                            </tr>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr class="warning no-result">
                                                                <td colspan="12"><i class="fa fa-warning"></i>&nbsp; No Result !!!</td>
                                                            </tr>
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
                                                                   
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
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




<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
