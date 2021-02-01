




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
                <div class="sidebar-brand-icon rotate-n-15"><i class="fas fa-user-graduate"></i></div>
                <div class="sidebar-brand-text mx-3"><span>Student</span></div>
            </a>
            <hr class="sidebar-divider my-0">
            <ul class="nav navbar-nav text-light" id="accordionSidebar">

                <li class="nav-item" role="presentation"><a class="nav-link " href="/sInfo"><i class="fas fa-address-card"></i><span>Student Info</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/sLibrary"><i class="fas fa-graduation-cap"></i><span>Library</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/sAttendance"><i class="fas fa-window-maximize"></i><span>Attendance</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/sResult"><i class="fas fa-window-maximize"></i><span>Result</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link active" href="/sNotice"><i class="fas fa-flag"></i><span>Notice</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/sSemesterFee"><i class="fas fa-flag"></i><span>Semester Fee</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/sAdmitCardGenerate"><i class="fas fa-flag"></i><span>Admit Card</span></a></li>
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
                                    class="dropdown-menu shadow dropdown-menu-right animated--grow-in" role="menu"><a class="dropdown-item" role="presentation" href="/studentProfile"><i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Profile</a> 
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

                                
                                <div >
                                   
                                    <div >

                                        <div class="container-fluid">
                                            <h3 class="text-dark mb-4"></h3>
                                            <div class="card shadow">
                                                <div class="card-header py-3">
                                                    <p class="text-primary m-0 font-weight-bold">Notice Board</p>
                                                </div>
                                                <div class="card-body">
                                                    
                                                    <div >
                                                        <table class="table dataTable my-0" id="dataTable">
                                                            <thead>
                                                                <tr>
                                                                    <th>ID</th>
                                                                    <th>Notice Header</th>
                                                                    <th>Notice Body</th>
                                                                    <th>Action</th>

                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <c:forEach items="${map.notice}" var="n">
                                                                    <tr>
                                                                        <td>${n.id}</td>
                                                                        <td>${n.noticeHeader}</td>
                                                                        <td>${n.noticeBody}</td>
                                                                
                                                                        <td><button class="btn-info" data-toggle="modal" data-target="#exampleModalLong" onclick="openNotice('${n.id}','${n.noticeHeader}','${n.noticeBody}','${n.privilege}')">View Notice</button></td>
                                                                    </tr>




                                                                    <!-- Modal -->
                                                                <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                                                                    <div class="modal-dialog" role="document">
                                                                        <div class="modal-content">
                                                                            <div class="modal-header">
<!--                                                                                <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>-->
                                                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                                    <span aria-hidden="true">&times;</span>
                                                                                </button>
                                                                            </div>
                                                                            <div class="modal-body">
                                                                                <div class="container">
                                                                                    <br/>
                                                                                    <div class="text-center">
                                                                                        <div>

                                                                                            <h3> <img src="/resources/vendor/css/assets/img/avatars/logo.png" alt="jacket" width="50" height="50"> East-West University</h3>
                                                                                        </div>



                                                                                    </div>
                                                                                    <br/>
                                                                                    <div class="text-center">
                                                                                        <p>12/A,Dhanmondi,Dhaka-1216 (Residence of)</p>
                                                                                        <div class="text-center">
                                                                                            <p>Phone: +8801799977777777</p>
                                                                                        </div>
                                                                                        <hr/>


                                                                                    </div>
                                                                                    <label class="text-center">
                                                                                        Date: 17/01/2021
                                                                                    </label> 
                                                                                    <label class="text-center">
                                                                                        Notice no: 
                                                                                    </label>

                                                                                    <div>
                                                                                        <div class="text-center">
                                                                                            <h4 >
                                                                                                Subject:  <label style="" id="header">Holidays</label>
                                                                                            </h4>
                                                                                        </div>

                                                                                        <div class="text-center">
                                                                                            <h4 style="">
                                                                                                Attention:  <label style="" id="privilege1">...</label>
                                                                                            </h4>
                                                                                        </div>

                                                                                        <div class="form-group">
                                                                                            <label for="exampleFormControlTextarea1"></label>
                                                                                            <textarea class="form-control" id="exampleFormControlTextarea1" rows="15"></textarea>
                                                                                        </div>

                                                                                    </div>







                                                                                </div>
                                                                            </div>
                                                                            <div class="modal-footer">
                                                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                                                <button type="button" class="btn btn-primary">Save changes</button>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </c:forEach>
                                                            </tbody>

                                                        </table>
                                                        
                                                        <script>
                                                            function openNotice(a,b,c,d){
                                                                $("#header").text(b);
                                                                $("#privilege1").text(d);
                                                                $("#exampleFormControlTextarea1").text(c);
                                                            }
                                                        </script>
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
