<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="langue" value="${not empty param.langue?param.langue: not empty langue?langue:pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${langue}"/>
        <fmt:setBundle basename="text"/>
<div><form action="identifier.jsp" method="post">
    <label><fmt:message key="login.lang" /></label>
        <select name="langue" onChange="this.form.submit()">
            <option value="fr" ${langue=='fr'?'selected':'' }>Français</option>
            <option value="en" ${langue=='en'?'selected':'' }>English</option>
        </select>
    </form>    </div>
<div>
<h1><em><fmt:message key="login.title" /></em></h1>
<div>
<form method="post" action="../identifierServlet">
<label>E-mail:</label>
<input type="email" name="email">
<div class="m">
<label><fmt:message key="login.password" />:</label>
<input type="password" name="password"> 
<input type="submit" value="OK" class="i">
</div>

</form>

</div>
 <c:if test="${not empty requestScope.error}">
        <p style="color: red; text-align:center;"><c:out value="${requestScope.error}" /></p>
    </c:if>
</div>

</body>
<style>
h1{
color:#f83e7b;
font-size:55px;
}
body{
display:flex;
justify-content:center;
}
input{
margin:20px;
}
.m {
  margin-left: -41px;
}
.i{
width: 90px;}

label{
color:blue;
}
</style>
</html>