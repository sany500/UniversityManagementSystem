




<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
   Document   : admin
   Created on : Dec 29, 2020, 11:47:34 AM
   Author     : sany5
--%>

<jsp:include page="/WEB-INF/jsp/common/header.jsp" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

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
                <li class="nav-item" role="presentation"><a class="nav-link active" href="/assignCourse"><i class="fab fa-adn"></i><span>Assign Courses</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/paymentView"><i class="fab fa-adn"></i><span>Payment</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/admitCard"><i class="fab fa-adn"></i><span>Admit Card</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/reports"><i class="fas fa-receipt"></i><span>Reports</span></a></li>
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


                    <p class="font-weight-bold"></p>

                    <div class="row">

                        <!-- Grid column -->
                        <div class="col-xl-12 mb-4 mb-xl-0">



                            <!-- Section: Live preview -->
                            <section>

                                <ul class="nav nav-tabs" id="myTab" role="tablist">
                                    <li class="nav-item waves-effect waves-light">
                                        <a class="nav-link" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="false">Assign Student</a>
                                    </li>
                                    <li class="nav-item waves-effect waves-light">
                                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Assign Faculty</a>
                                    </li>

                                </ul>
                                <div class="tab-content" id="myTabContent">
                                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">

                                        <section>
                                            <div class="container " style="margin-top: 1rem;">
                                                <div class="row justify-content-center ">
                                                    <div class="col-12 col-md-8 col-lg-8 col-xl-6">
                                                        <div class="row">
                                                            <div class="col text-center ">


                                                            </div>
                                                        </div>

                                                        <form action="/ascSave" method="post">
                                                            <h2 class="text-center">Assign Student</h2>
                                                            Select Student
                                                            <div class="form-group">
                                                                <select id="selectStudent" class="form-control mb-3"> 
                                                                <c:forEach items="${map.students}" var="stu">
                                                                    <option value="${stu.id}">${stu.name}</option>
                                                                    

                                                                </c:forEach>
                                                                </select>
                                                            </div>
                                                            Select Semester
                                                            <div class="form-group"><select id="selectSemester" class="form-control mb-3"> 
                                                                  <c:forEach items="${map.semesters}" var="sm">
                                                                    <option value="${sm.id}">${sm.semesterName}</option>
                                                                    
                                                                </c:forEach>
                                                                </select>
                                                            </div>
                                                            Select Courses
                                                            <div class="form-group"><select class="form-control mb-3" id="selectCourse">
                                                                    
                                                                <c:forEach items="${map.courses}" var="course">
                                                                    <option value="${course.id}">${course.courseName}</option>
                                                                    

                                                                </c:forEach>
                                                            </select>
                                                            </div>
                                                            
                                                            <!--For Student Select -->  
                                                            <input type="hidden" name="sid" value="" id="sid"/>
                                                            <input type="hidden" name="name" value="" id="name"/>
                                                            <input type="hidden" name="email" value="" id="email"/>
                                                            <input type="hidden" name="phone" value="" id="phone"/>
                                                            <input type="hidden" name="address" value="" id="address"/>
                                                            <input type="hidden" name="fName" value="" id="fName"/>
                                                            <input type="hidden" name="mName" value="" id="mName"/>
                                                            <input type="hidden" name="dob" value="" id="dob"/>
                                                            <input type="hidden" name="religion" value="" id="religion"/>
                                                            <input type="hidden" name="bloodGroup" value="" id="bloodGroup"/>
                                                            <input type="hidden" name="gender" value="" id="gender"/>

                                                              <!--For Semester Select --> 
                                                              <input type="hidden" name="semesterCode" value="" id="semesterCode"/>
                                                              <input type="hidden" name="semesterName" value="" id="semesterName"/>
                                                              <input type="hidden" name="uniCode" value="" id="uniCode"/>
                                                              <input type="hidden" name="uniName" value="" id="uniName"/>
                                                              
                                                               <!--For Course Select --> 
                                                              <input type="hidden" name="courseCode" value="" id="courseCode"/>
                                                              <input type="hidden" name="courseName" value="" id="courseName"/>
                                                              <input type="hidden" name="deptCode" value="" id="deptCode"/>
                                                              <input type="hidden" name="deptName" value="" id="deptName"/>

                                                            <div class="form-group"><button class="btn  btn-primary btn-block" type="submit">Submit</button></div>
                                                        </form>
                                                        <script>
                                                            selectCourse();
                                                            selectStudent();
                                                            selectSemester();
                                                            
                                                            $("#selectStudent").change(function () {
                                                                
                                                               selectStudent();

                                                            });
                                                            
                                                            function selectStudent(){
                                                                 $.ajax({
                                                                    url: 'getStudent/'+$("#selectStudent :selected").val(),
                                                                    type: 'GET',
                                                                    dataType: 'json',
                                                                    success:function(data){
                                                                        
                                                                     //$("#id").val(data.id);
                                                                     $("#sid").val(data.sid);
                                                                     $("#name").val(data.name);
                                                                     $("#email").val(data.email);
                                                                     $("#phone").val(data.phone);
                                                                     $("#address").val(data.address);
                                                                     $("#fName").val(data.fName);
                                                                     $("#mName").val(data.mName);
                                                                     $("#dob").val(data.dob);
                                                                     $("#religion").val(data.religion);
                                                                     $("#bloodGroup").val(data.bloodGroup);
                                                                     $("#gender").val(data.gender);
                                                                     
                                                                    }
                                                                    
           

                                                                });
                                                            }
                                                            
                                                            
                                                            
                                                            $("#selectSemester").change(function () {
                                                                 
                                                               selectSemester();

                                                            });
                                                            
                                                            
                                                            function selectSemester(){
                                                                 $.ajax({
                                                                    url: 'getSemester/'+$("#selectSemester :selected").val(),
                                                                    type: 'GET',
                                                                    dataType: 'json',
                                                                    success:function(data1){
                                                                        
                                                                     //$("#id").val(data.id);
                                                                     $("#semesterCode").val(data1.semesterCode);
                                                                     $("#semesterName").val(data1.semesterName);
                                                                     $("#uniCode").val(data1.uniCode);
                                                                     $("#uniName").val(data1.uniName);
                                                                     
                                                                    }
                                                                    
           

                                                                });
                                                            }
                                                            
                                                             $("#selectCourse").change(function () {
                                                                
                                                                selectCourse();

                                                            });
                                                            
                                                            function selectCourse(){
                                                               $.ajax({
                                                                    url: 'getCourse/'+$("#selectCourse :selected").val(),
                                                                    type: 'GET',
                                                                    dataType: 'json',
                                                                    success:function(data2){
                                                                        
                                                                     //$("#id").val(data.id);
                                                                     $("#courseCode").val(data2.courseCode);
                                                                     $("#courseName").val(data2.courseName);
                                                                     $("#deptCode").val(data2.deptCode);
                                                                     $("#deptName").val(data2.deptName);
                                                                    }
                                                                    
           

                                                                }); 
                                                            }
                                                        </script>  
                                                    </div>




                                                </div>
                                            </div>
                                        </section>

                                    </div>
                                    <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                        
                                        <section>
                                            <div class="container " style="margin-top: 1rem;">
                                                <div class="row justify-content-center ">
                                                    <div class="col-12 col-md-8 col-lg-8 col-xl-6">
                                                        <div class="row">
                                                            <div class="col text-center ">


                                                            </div>
                                                        </div>

                                                        <form action="/afcSave" method="post">
                                                            <h2 class="text-center">Assign Faculty</h2>
                                                            Select Faculty
                                                            <div class="form-group">
                                                                <select class="form-control mb-3" name="uniId" id="sFaculty">
                                                                <c:forEach items="${map.facultys}" var="faculty">
                                                                   
                                                                    <option value="${faculty.id}">${faculty.name}</option>

                                                                </c:forEach>
                                                            </select>
                                                            </div>
                                                            Select Semester
                                                              <div class="form-group">
                                                                  <select class="form-control mb-3" name="uniId" id="sSemester">
                                                                 <c:forEach items="${map.semesters}" var="sm">
                                                                    <option value="${sm.id}">${sm.semesterName}</option>
                                                                    
                                                                </c:forEach>
                                                            </select>
                                                            </div>
                                                            Select Courses
                                                            <div class="form-group"><select class="form-control mb-3" id="sCourse">
                                                                    
                                                               <c:forEach items="${map.courses}" var="course">
                                                                    <option value="${course.id}">${course.courseName}</option>
                                                                    

                                                                </c:forEach>
                                                            </select>
                                                            </div>
                                                            <!--For Student Select -->  
                                                            <input type="hidden" name="fid" value="" id="fid"/>
                                                            <input type="hidden" name="name" value="" id="fname"/>
                                                            <input type="hidden" name="email" value="" id="femail"/>
                                                            <input type="hidden" name="phone" value="" id="fphone"/>
                                                            <input type="hidden" name="address" value="" id="faddress"/>
                                                            <input type="hidden" name="designation" value="" id="fdesignation"/>
                                                            
                                                            <input type="hidden" name="dob" value="" id="fdob"/>
                                                            <input type="hidden" name="religion" value="" id="freligion"/>
                                                            <input type="hidden" name="bloodGroup" value="" id="fbloodGroup"/>
                                                            <input type="hidden" name="gender" value="" id="fgender"/>

                                                              <!--For Semester Select --> 
                                                              <input type="hidden" name="semesterCode" value="" id="fsemesterCode"/>
                                                              <input type="hidden" name="semesterName" value="" id="fsemesterName"/>
                                                              <input type="hidden" name="uniCode" value="" id="funiCode"/>
                                                              <input type="hidden" name="uniName" value="" id="funiName"/>
                                                              
                                                               <!--For Course Select --> 
                                                              <input type="hidden" name="courseCode" value="" id="fcourseCode"/>
                                                              <input type="hidden" name="courseName" value="" id="fcourseName"/>
                                                              <input type="hidden" name="deptCode" value="" id="fdeptCode"/>
                                                              <input type="hidden" name="deptName" value="" id="fdeptName"/>




                                                            <div class="form-group"><button class="btn  btn-primary btn-block" type="submit">Submit</button></div>
                                                        </form>
                                                        <script>
                                                            selectFaculty();
                                                            selectFacultySemester();
                                                            selectFacultyCourse();
                                                            $("#sFaculty").change(function () {
                                                                selectFaculty();
                                                                
                                                            });
                                                            
                                                            function selectFaculty(){
                                                                $.ajax({
                                                                    url: 'getFaculty/'+$("#sFaculty :selected").val(),
                                                                    type: 'GET',
                                                                    dataType: 'json',
                                                                    success:function(data){
                                                                       
                                                                     //$("#id").val(data.id);
                                                                     $("#fid").val(data.fid);
                                                                     $("#fname").val(data.name);
                                                                     $("#femail").val(data.email);
                                                                     $("#fphone").val(data.phone);
                                                                     $("#faddress").val(data.address);
                                                                     $("#fdesignation").val(data.designation);
                                                                    
                                                                     $("#fdob").val(data.dob);
                                                                     $("#freligion").val(data.religion);
                                                                     $("#fbloodGroup").val(data.bloodGroup);
                                                                     $("#fgender").val(data.gender);
                                                                     
                                                                    }
                                                                    
           

                                                                });
                                                            }
                                                            
                                                            $("#sSemester").change(function () {
                                                                 
                                                               selectFacultySemester();

                                                            });
                                                            
                                                            function selectFacultySemester(){
                                                                 $.ajax({
                                                                    url: 'getSemester/'+$("#sSemester :selected").val(),
                                                                    type: 'GET',
                                                                    dataType: 'json',
                                                                    success:function(data1){
                                                                        
                                                                     //$("#id").val(data.id);
                                                                     
                                                                     $("#fsemesterCode").val(data1.semesterCode);
                                                                     $("#fsemesterName").val(data1.semesterName);
                                                                     $("#funiCode").val(data1.uniCode);
                                                                     $("#funiName").val(data1.uniName);
                                                                     
                                                                    }
                                                                    
           

                                                                });
                                                            }
                                                            
                                                            function selectFacultyCourse(){
                                                                $.ajax({
                                                                    url: 'getCourse/'+$("#sCourse :selected").val(),
                                                                    type: 'GET',
                                                                    dataType: 'json',
                                                                    success:function(data2){
                                                                      
                                                                     //$("#id").val(data.id);
                                                                     $("#fcourseCode").val(data2.courseCode);
                                                                     $("#fcourseName").val(data2.courseName);
                                                                     $("#fdeptCode").val(data2.deptCode);
                                                                     $("#fdeptName").val(data2.deptName);
                                                                    }
                                                                    
           

                                                                });
                                                            }
                                                             $("#sCourse").change(function () {
                                                                
                                                                selectFacultyCourse();

                                                            });
                                                        </script>  
                                                    </div>




                                                </div>
                                            </div>
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




<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
