<%-- 
    Document   : admin
    Created on : Dec 29, 2020, 11:47:34 AM
    Author     : sany5
--%>

<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">
    <h1 class="form-heading">login Form</h1>
    <div class="login-form">
        <div class="main-div">
            <div class="panel">
                <h2>Admin Login</h2>
                <p >Please enter your email and password</p>
                <p style="color: #d52a1a">${map.status}</p>
            </div>
            <form id="Login" action="/loginSuccess" method="POST">
                
                <div class="form-group">


                    <input type="email" class="form-control" name="email" id="inputEmail" placeholder="Email Address" >

                </div>

                <div class="form-group">

                    <input type="password" class="form-control" name="password" id="inputPassword" placeholder="Password" >

                </div>
                <div class="forgot">
                    <a href="reset.html">Forgot password?</a>
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
             
            </form>
        </div>

    </div>
</div>

<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
