
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

                            <div class="container-fluid">
                                <div class="container mt-5">
                                    <div><h4 class="p-0 m-0 pb-3 d-flex justify-content-center">Confirm Book Approval</h4></div><hr/>



                                    


                                    <form action="/approveBookRequest" method="post">
                                        <div class="form-row p-0 m-0">

                                            <div class="col-lg-6 col-xl-6 p-0 m-0 p-3" id="formPersonal">
                                                <div class="form-group text-dark"><h3>Book Information</h3></div><hr/>
                                                <input type="hidden"   name="id" value="${map.book.id}">
                                                <div class="form-group"><input class="form-control" type="hidden" name="sid" value="${map.book.sid}"></div>
                                                <div class="form-group"><input class="form-control" type="hidden" name="name" value="${map.book.name}"></div>
                                                <div class="form-group"><input class="form-control" type="hidden" name="email"  value="${map.book.email}"></div>
                                                <div class="form-group"><input class="form-control" type="hidden" name="phone" value="${map.book.phone}"></div>
                                                <div class="form-group"><input class="form-control" type="hidden" name="address" value="${map.book.address}"></div>
                                                <div class="form-group text-dark">Book Name:       ${map.book.bookName}</div>
                                                <div class="form-group text-dark">Author Name:     ${map.book.author}</div>
                                                <div class="form-group text-dark">Book Genre       ${map.book.genre}</div>
                                                <div class="form-group text-dark">Publisher:       ${map.book.publisher}</div>
                                                <div class="form-group text-dark">Available Books: ${map.book.quantity}</div>
                                                
                                                

                                            </div>
                                            <div class="col-lg-6 col-xl-6 p-0 m-0 p-3" id="formPersonal">
                                                <div class="form-group text-dark"><h3>Requester Information</h3></div><hr/>
                                                <div class="form-group"><input class="form-control" type="hidden" name="bookCode" value="${map.book.bookCode}"></div>
                                                <div class="form-group"><input class="form-control" type="hidden"  name="bookName" value="${map.book.bookName}"></div>
                                                <div class="form-group"><input class="form-control" type="hidden"  name="author" value="${map.book.author}"></div>
                                                <div class="form-group"><input class="form-control" type="hidden" name="genre" value="${map.book.genre}"></div>
                                                <div class="form-group"><input class="form-control" type="hidden" name="publisher" value="${map.book.publisher}"></div>
                                                <div class="form-group"><input class="form-control" type="hidden" name="quantity" value="${map.book.quantity}"></div>
                                                <div class="form-group"><input class="form-control" type="hidden" name="edition"  value="${map.book.edition}"></div>
                                                <div class="form-group"><input class="form-control" type="hidden" name="price"  value="${map.book.price}"></div>
                                                <div class="form-group text-dark">Requested By: ${map.book.name}</div>
                                                <div class="form-group text-dark">Requester Email: ${map.book.email}</div>
                                                <div class="form-group text-dark">Requester Id: ${map.book.sid}</div>
                                                <div class="form-group text-dark">Requester Phone: ${map.book.phone}</div>
                                                <div class="form-group text-dark">Requester Address: ${map.book.address}</div>
                                                
                                            </div>



                                            <div class="col p-0 m-0 p-3 d-flex justify-content-end"><input class="btn btn-primary btn-block" type="submit" value="Approve"/></div>
                                        </div>
                                    </form>
                                </div>
                            </div>

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
