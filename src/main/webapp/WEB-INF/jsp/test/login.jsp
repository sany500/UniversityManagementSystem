<%-- 
    Document   : admin
    Created on : Dec 29, 2020, 11:47:34 AM
    Author     : sany5
--%>

<jsp:include page="/WEB-INF/jsp/common/header.jsp" />


<div class="container">
    <h1 class="form-heading">login Form</h1>
    <div class="login-form">
        <div class="main-div">
            <div class="panel">
                <h2>Login Faculty or Student</h2>
                <p>Please enter your email and password</p>
            </div>
            <form name='loginForm' action="/login" method='POST'>

                <div class="form-group">


                    <input type="text" class="form-control" name="username" id="inputEmail" placeholder="Email Address" >

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
