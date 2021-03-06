

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
                <li class="nav-item" role="presentation"><a class="nav-link active" href="/sLibrary"><i class="fas fa-graduation-cap"></i><span>Library</span></a></li>
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
            <div class="container-fluid">
                <div class="container my-4">


                    <p class="font-weight-bold"></p>

                    <div class="row">





                        <!-- Grid column -->
                        <div class="col-xl-12 mb-4 mb-xl-0">



                            <!-- Section: Live preview -->
                            <section>







                                <!-- Insert Section-->





                                <section>

                                    <div class="container-fluid">
                                        <div class="container mt-5">
                                            <div><h4 class="p-0 m-0 pb-3 d-flex justify-content-center">Request For Book</h4></div>






                                            <form action="/bookRequestSave" method="post">
                                                <div class="form-row p-0 m-0">

                                                    <div class="col-lg-6 col-xl-6 p-0 m-0 p-3 " id="formPersonal">

                                                        <div class="form-group"><input class="form-control" type="hidden" value="${map.book.bookCode}" name="bookCode" ></div>
                                                        <div class="form-group"><input class="form-control" type="hidden" value="${map.book.bookName}" name="bookName" ></div>
                                                        <div class="form-group"><input class="form-control" type="hidden" value="${map.book.author}" name="author"  ></div>
                                                        <div class="form-group"><input class="form-control" type="hidden" value="${map.book.genre}" name="genre" ></div>
                                                        <div class="form-group"><input class="form-control" type="hidden" value="${map.book.publisher}" name="publisher" ></div>
                                                        <div class="form-group"><input class="form-control" type="hidden" value="${map.book.quantity}" name="quantity" ></div>
                                                        <div class="form-group"><input class="form-control" type="hidden" value="${map.book.edition}" name="edition" ></div>
                                                        <div class="form-group"><input class="form-control" type="hidden" value="${map.book.price}" name="price" ></div>

                                                        <div class="form-group text-dark">Book Name:       ${map.book.bookName}</div>
                                                        <div class="form-group text-dark">Author Name:     ${map.book.author}</div>



                                                    </div>
                                                    <div class="col-lg-6 col-xl-6 p-0 m-0 p-3 " id="formPersonal">
                                                        <div class="form-group"><input class="form-control" type="hidden" value="${map.book.bookCode}" name="bookCode" ></div>
                                                        <div class="form-group text-dark">Publisher:       ${map.book.publisher}</div>
                                                        <div class="form-group text-dark">Book Genre       ${map.book.genre}</div>
                                                        

                                                    </div>

                                                    <div class="col p-0 m-0 p-3 d-flex justify-content-end"><input class="btn btn-primary btn-block" type="submit" value="Confirm Book Request"/></div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>

                                    <script>
                                        $("#selectStudent1").click(function () {

                                            $.ajax({
                                                url: 'getStudent/' + this.value,
                                                type: 'GET',
                                                dataType: 'json',
                                                success: function (data) {

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

                                        });
                                    </script>
                                </section>





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
                <div class="text-center my-auto copyright"><span>Copyright � Mezbaur Rahman 2020-2021</span></div>
            </div>
        </footer>
    </div><a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a></div>




<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
