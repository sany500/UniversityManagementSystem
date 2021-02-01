




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
                <li class="nav-item" role="presentation"><a class="nav-link active" href="/library"><i class="fas fa-book"></i><span>Library</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/notice"><i class="fas fa-flag"></i><span>Notice</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link " href="/assignCourse"><i class="fab fa-adn"></i><span>Assign Courses</span></a></li>
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
                                        <a class="nav-link" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="false">Add Book</a>
                                    </li>
                                    <li class="nav-item waves-effect waves-light">
                                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Book Requests</a>
                                    </li>

                                </ul>
                                <div class="tab-content" id="myTabContent">
                                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">

                                        <section>
                                            <div class="container-fluid">
                                                <div class="container mt-5">
                                                    <div ><h4 class="p-0 m-0 pb-3 d-flex justify-content-center">Add Book</h4></div>
                                                    <form action="/bookSave" method="post">
                                                        <div class="form-row p-0 m-0">

                                                            <div class="col-lg-6 col-xl-6 p-0 m-0 p-3" id="formPersonal">

                                                                <div class="form-group"><input class="form-control" type="text" name="bookCode" placeholder="Book Code"></div>
                                                                <div class="form-group"><input class="form-control" type="text"  name="bookName"placeholder="Book Name"></div>
                                                                <div class="form-group"><input class="form-control" type="text"  name="author" placeholder="Author"></div>
                                                                <div class="form-group"><input class="form-control" type="text" name="genre" placeholder="Genre"></div>

                                                            </div>
                                                            <div class="col-lg-6 col-xl-6 p-0 m-0 p-3" id="formPersonal">

                                                                <div class="form-group"><input class="form-control" type="text" name="publisher" placeholder="Publisher"></div>
                                                                <div class="form-group"><input class="form-control" type="text" name="quantity" placeholder="Quantity"></div>
                                                                <div class="form-group"><input class="form-control" type="text" name="edition"  placeholder="Edition"></div>
                                                                <div class="form-group"><input class="form-control" type="text" name="price"  placeholder="Price"></div>

                                                            </div>


                                                            <div class="col p-0 m-0 p-3 d-flex justify-content-end"><input class="btn btn-primary btn-block" type="submit" value="Add Book"></button></div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </section>

                                    </div>
                                    <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">

                                        <div class="container shadow" style="background-color: #ffffff;margin-top: 0px;">
                                            <div class="row no-gutters text-left justify-content-center align-items-center" style="height: 100%;">
                                                <div class="col-md-12 search-table-col" style="margin-top: 0px;">
                                                    <div class="form-group pull-right col-lg-4"><input type="text" class="search form-control" placeholder="Search by typing here.."></div><span class="counter pull-right" style="color: rgb(88,82,82);font-size: 22px;"></span>
                                                    <div class="table-responsive table-bordered table table-hover table-bordered results"
                                                         style="width: 100%;">
                                                        <table class="table table-bordered table-hover">
                                                            <thead class="bill-header cs">
                                                                <tr>
                                                                    <th> Book Code</th>
                                                                    <th> Book Name</th>
                                                                    <th> Author</th>
                                                                    <th> Genre</th>
                                                                    <th> Publisher</th>
                                                                    <th>Quantity</th>
                                                                    <th>Requested By</th>
                                                                    <th>Price</th>
                                                                    <th>Status</th>
                                                                    <th>Action</th>




                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <tr class="warning no-result">
                                                                    <td colspan="12"><i class="fa fa-warning"></i>&nbsp; No Result !!!</td>
                                                                </tr>
                                                                <c:forEach items="${map.books}" var="book">

                                                                    <tr>

                                                                        <td>${book.bookCode}</td>
                                                                        <td>${book.bookName}</td>
                                                                        <td>${book.author}</td>
                                                                        <td >${book.genre}</td>
                                                                        <td>${book.publisher}</td>
                                                                        <td>${book.quantity}</td>
                                                                        <td>${book.name}</td>
                                                                        <td>${book.price}</td>
                                                                        <td>${book.status}</td>
                                                                        <td><a href="/bookApproval/${book.id}"><button class="btn btn-warning btn-sm text-dark">Details</button></a></td>


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
