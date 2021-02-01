<%-- 
    Document   : test
    Created on : Jan 27, 2021, 9:05:48 PM
    Author     : sany5
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/test/header.jsp" />

<h1>Hello world</h1>

<c:forEach items="${map.notice}" var="n">
    <p>${n.noticeHeader}</p>
</c:forEach>


<jsp:include page="/WEB-INF/jsp/test/footer.jsp" />
