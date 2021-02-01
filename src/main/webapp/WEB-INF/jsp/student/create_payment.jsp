




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
                <div class="sidebar-brand-icon rotate-n-15"><i class="fas fa-user-graduate"></i></div>
                <div class="sidebar-brand-text mx-3"><span>Student</span></div>
            </a>
            <hr class="sidebar-divider my-0">
            <ul class="nav navbar-nav text-light" id="accordionSidebar">


                <li class="nav-item" role="presentation"><a class="nav-link " href="/sInfo"><i class="fas fa-address-card"></i><span>Student Info</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/sLibrary"><i class="fas fa-graduation-cap"></i><span>Library</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link active " href="/sAttendance"><i class="fas fa-window-maximize"></i><span>Attendance</span></a></li>
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
            <div class="container">

                <div class="container" id="div2">
                    <div class="row">
                        <div class="col-md-4">
                            <h3>Semester Fee Details</h3> 
                            <table>
                                <tr>
                                    <td>Tution Fee:</td>
                                    <td>${map.sf.tutionFee}</td>
                                </tr>

                                <tr>
                                    <td>Special Fee:</td>
                                    <td>${map.sf.specialFee}</td>
                                </tr>
                                <tr>
                                    <td>Facilities Service:</td>
                                    <td>${map.sf.facilitiesFee}</td>
                                </tr>
                                <tr>
                                    <td>Student Id Fee:</td>
                                    <td>${map.sf.studentIdFee}</td>
                                </tr>
                                <tr>
                                    <td>Library Fee:</td>
                                    <td>${map.sf.libraryFee}</td>
                                </tr>
                                <tr>
                                    <td>Technology Fee:</td>
                                    <td>${map.sf.technologyFee}</td>
                                </tr>
                                <tr>
                                    <td>Registration Fee:</td>
                                    <td>${map.sf.registrationFee}</td>
                                </tr>
                                <tr>
                                    <td>Housing Fee:</td>
                                    <td>${map.sf.housingFee}</td>
                                </tr>
                                <tr>
                                    <td>Financial Aid</td>
                                    <td>${map.sf.financialAid}</td>
                                </tr>



                            </table>
                            <hr/>
                            <table>
                                <tr>
                                    <td> Total =</td>
                                    <td>${map.sf.totalFee}</td>
                                </tr> 
                            </table>






                        </div>
                        <div class="col-md-8">
                            <div class="wizard-content">
                                <!--                    <form class="tab-wizard wizard-circle wizard vertical" action="/payment/save" method="POST">-->
                                <h1 class="py-1" >Payment Info</h1>
                                <div style="margin-left: 10px">
                                    <img src="/resources/vendor/css/assets/img/avatars/bkash.png" alt="Master Card"/>
                                    <img src="/resources/vendor/css/assets/img/avatars/logo-mastercard-mobile.svg" width="231px" height="154px" alt="Master Card"/>
                                </div><br/>
                                <section>
                                    <form action="/paymentSave" method="post">
                                        <div class="row">
                                            <div class="col-md-6">

                                                Student Name:
                                                <div class="form-group">
                                                    <label>${map.user.userName}</label>
                                                </div>
                                                Select Semester:
                                                <div class="form-group"><select class="form-control" name="semesterName" >
                                                        <c:forEach items="${map.semesters}" var="sm">
                                                            <option value="${sm.semesterName}">${sm.semesterName}</option>
                                                        </c:forEach>
                                                    </select></div>
                                                <div class="form-group">
                                                    <label>Payment Method:</label>
                                                    <select class="form-control" name="paymentMethod">
                                                        <option>Select Card</option>
                                                        <option value="bkash">Card</option>
                                                        <option value="rocket">Rocket</option>
                                                        <option value="rocket">Rocket</option>

                                                    </select> </div>


                                            </div>
                                            <div class="col-md-6 mb-3">
                                                <div class="form-group">
                                                    <label>Card/Mobile No:</label>
                                                    <input class="form-control" id="caedno" name="mobileNo"  type="text">

                                                    <label>Transaction Id:</label>
                                                    <input class="form-control" id="caedno" name="trId"  type="text">

                                                    <label>Total Payment:</label>
                                                    <input class="form-control"   value="${map.sf.totalFee}"  type="text" disabled="">
                                                    <input type="hidden" name="studentName" value="${map.user.userName}" id="studentName"/>
                                                    <input type="hidden" name="studentId" value="${map.user.userId}" id="studentId"/>
                                                    <input type="hidden" name="tutionFee"  value="${map.sf.tutionFee}"/>
                                                    <input type="hidden" name="specialFee"  value="${map.sf.specialFee}"/>
                                                    <input type="hidden" name="facilitiesFee"  value="${map.sf.facilitiesFee}"/>
                                                    <input type="hidden" name="studentIdFee"  value="${map.sf.studentIdFee}"/>
                                                    <input type="hidden" name="libraryFee"  value="${map.sf.libraryFee}"/>
                                                    <input type="hidden" name="technologyFee"  value="${map.sf.technologyFee}"/>
                                                    <input type="hidden" name="registrationFee"  value="${map.sf.registrationFee}"/>
                                                    <input type="hidden" name="housingFee"  value="${map.sf.housingFee}"/>
                                                    <input type="hidden" name="financialAid"  value="${map.sf.financialAid}"/>
                                                    <input type="hidden"  name="totalPayment" value="${map.sf.totalFee}"/>


                                                </div>
                                            </div>
                                        </div>

                                        <button type="submit" class="btn btn-primary">Submit</button>

                                    </form>


                                </section>



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
