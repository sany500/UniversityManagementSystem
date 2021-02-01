




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


                    <p class="font-weight-bold">Basic examples</p>

                    <div class="row">

                        <!-- Grid column -->
                        <div class="col-xl-12 mb-4 mb-xl-0">



                            <!-- Section: Live preview -->
                            <section>

                                
                                <div >
                                    
                                        <div class="d-flex justify-content-center"><h3>Create Attendance</h3></div>
                                        <section>
                                            
                                                <div class="form-row p-0 m-0">

                                                    <div class="col-lg-12 col-xl-12 p-0 m-0 p-3" id="formPersonal">
                                                        <form action="/createAttendance" method="post">
                                                        <div class="form-group d-flex justify-content-center"><select class="form-control"  name="courseName">
                                                                <c:forEach items="${map.afc}" var="c">
                                                                    <option value="${c.courseName}">${c.courseName}</option>
                                                                </c:forEach>
                                                            </select></div>
                                                            
                                                            <div class="form-group d-flex justify-content-center"><select class="form-control"  name="semesterName">
                                                                <c:forEach items="${map.afc}" var="sm">
                                                                    <option value="${sm.semesterName}">${sm.semesterName}</option>
                                                                </c:forEach>
                                                            </select></div>
                                                            
                                                            
                                                        

<!--                                                        <div class="form-group"><input class="form-control" type="text" name="address" placeholder="Address"></div>
                                                        <div class="form-group"><input class="form-control" type="text" name="address" placeholder="Address"></div>-->
                                                        <!-- <div class="form-group"><input class="form-control" type="tel" required="" placeholder="LinkedIn"></div> -->
                                                        
                                                        <div class="d-flex justify-content-center"><input type="submit" class="btn btn-info" value="Search"></div>
                                                        
                                                        
                                                        </form>
                                                    </div>



                                                    <!-- <div class="col p-0 m-0 p-3 d-flex justify-content-end"><button class="btn btn-primary btn-block" type="button">Submit</button></div> -->

                                                    
                                                    
                                            
                                        </section>

                                    
                                    

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
