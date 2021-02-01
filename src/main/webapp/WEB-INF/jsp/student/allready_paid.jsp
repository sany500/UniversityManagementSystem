<%-- 
    Document   : allready_paid
    Created on : Jan 23, 2021, 3:25:01 PM
    Author     : B13
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/common/header.jsp" />

<div id="wrapper">
    <nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0">
        <div class="container-fluid d-flex flex-column p-0">
            <a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#">
                <div class="sidebar-brand-icon rotate-n-15"><i class="fas fa-user-graduate"></i></div>
                <div class="sidebar-brand-text mx-3"><span>Student</span></div>
            </a>
            <hr class="sidebar-divider my-0">
            <ul class="nav navbar-nav text-light" id="accordionSidebar">

                <li class="nav-item" role="presentation"><a class="nav-link active" href="/sInfo"><i class="fas fa-address-card"></i><span>Student Info</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/sLibrary"><i class="fas fa-graduation-cap"></i><span>Library</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/sAttendance"><i class="fas fa-window-maximize"></i><span>Attendance</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/sResult"><i class="fas fa-window-maximize"></i><span>Result</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/sNotice"><i class="fas fa-flag"></i><span>Notice</span></a></li>
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

            <div class="alert alert-success" role="alert">
                <h4 class="alert-heading text-center">You Have Allready paid ${map.payment.studentName}!</h4>
                <div class="d-flex justify-content-center"><h3>Your Payment Information</h3></div>
                <div class="card mb-3 text-green">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Full Name</h6>
                            </div>
                            <div class="col-sm-9 text-secondary text-dark">
                                ${map.payment.studentName}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Email</h6>
                            </div>
                            <div class="col-sm-9 text-secondary text-dark">
                                ${map.user.userEmail}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Payment Method</h6>
                            </div>
                            <div class="col-sm-9 text-secondary text-dark">
                                ${map.payment.paymentMethod}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Card/Mobile No.</h6>
                            </div>
                            <div class="col-sm-9 text-secondary text-dark">
                                ${map.payment.mobileNo}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Transaction Id</h6>
                            </div>
                            <div class="col-sm-9 text-secondary text-dark">
                                ${map.payment.trId}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Payment Amount</h6>
                            </div>
                            <div class="col-sm-9 text-secondary text-dark">
                                ${map.payment.totalFee}/-
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Payment Date</h6>
                            </div>
                            <div class="col-sm-9 text-secondary text-dark">
                                ${map.payment.paymentDate}
                            </div>
                        </div>
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