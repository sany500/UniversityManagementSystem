<%-- 
    Document   : admit_card
    Created on : Jan 26, 2021, 9:19:15 PM
    Author     : sany5
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<style>
    .txt-center {
        text-align: center;
    }

    .border- {
        border: 1px solid #000 !important;
    }

    .padding {
        padding: 15px;
    }

    .mar-bot {
        margin-bottom: 15px;
    }

    .admit-card {
        border: 2px solid #000;
        padding: 15px;
        margin: 20px 0;
    }

    .BoxA h5,
    .BoxA p {
        margin: 0;
    }

    h5 {
        text-transform: uppercase;
    }

    table img {
        width: 100%;
        margin: 0 auto;
    }

    .table-bordered td,
    .table-bordered th,
    .table thead th {
        border: 1px solid #000000 !important;
    }
</style>




<section>
    <div class="container">
        <div class="admit-card">
            <div class="BoxA border- padding mar-bot">
                <div class="row">
                    <div class="col-sm-4">
                        <h5>East-West University</h5>
                        <p>Jahurul Islam City Gate <br>A/2 Jahurul Islam Ave,

                            Dhaka 1212</p>
                    </div>
                    <div class="col-sm-4 txt-center">
                        <img src="/resources/vendor/css/assets/img/avatars/logoUniversity.png" width="100px;" />
                    </div>
                    <div class="col-sm-4">
                        <h5>Admit Card</h5>
                        <p>Spring - 2020-2021</p>
                    </div>
                </div>
            </div>
            <div class="BoxC border- padding mar-bot">
                <div class="row">
                    <div class="col-sm-6">
                        <h5>Enrollment No : ${map.st.sid}</h5>
                    </div>
                </div>
            </div>
            <div class="BoxD border- padding mar-bot">
                <div class="row">
                    <div class="col-sm-10">
                        <table class="table table-bordered">
                            <tbody>
                                <tr>
                                    <td><b>ENROLLMENT NO : ${map.st.sid}</b></td>
                                    <td><b>DOB: </b>${map.st.dob}</td>
                                </tr>
                                <tr>
                                    <td><b>Student Name: </b>${map.st.name}</td>
                                    <td><b>Sex: </b>${map.st.gender}</td>
                                </tr>
                                <tr>
                                    <td><b>Father/Husband Name: </b>${map.st.fName}</td>
                                    <td><b>Religion: </b>${map.st.religion}</td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="    height: 125px;"><b>Address: </b>${map.st.address}
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-sm-2 txt-center">
                        <table class="table table-bordered">
                            <tbody>
                                <tr>
                                    <th scope="row txt-center"><img
                                            src="/resources/vendor/css/assets/img/avatars/profile_pic.png"
                                            width="123px" height="165px" /></th>
                                </tr>
                                <tr>
                                    <th scope="row txt-center"><img
                                            src="http://peoplehelp.in/mewaruni/images/hj.png"  alt="Your Signature Here"/></th>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="BoxE border- padding mar-bot txt-center">
                <div class="row">
                    <div class="col-sm-12">
                        <h5>EXAMINATION VENUE</h5>
                        <p>East-West University <br>A/2 Jahurul Islam Ave,

                            Dhaka 1212</p>
                    </div>
                </div>
            </div>
            <div class="BoxF border- padding mar-bot txt-center">
                <div class="row">
                    <div class="col-sm-12">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Sr. No.</th>
                                    <th>Subject/Paper</th>
                                    <th>Exam Date</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${map.courses}" var="asc">
                                    <tr>
                                        <td>${asc.courseCode}</td>
                                        <td>${asc.courseName}</td>

                                        <td>5 July 2019</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <footer class="txt-center">
                <p>*** East-West University ***</p>
            </footer>

        </div>
    </div>
    <div class="d-flex justify-content-center"><button class="btn btn-warning" onclick="print()">Print</button></div>             
</section>


<script>
    print(){
        window.print();
    }
</script>
