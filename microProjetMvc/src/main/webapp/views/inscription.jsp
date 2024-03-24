<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<h1><em>Inscrivez-vous</em></h1>
<div>
<form method="post" action="../inscriptionServlet">
<div>
<label>
Nom:
</label>
<input type="text"name="nom">
</div>
<div>
<label>
Prenom:
</label>
<input type="text"name="prenom">
</div>
<div>
<label>
Adresse:</label>
<input type="text"name="adresse"><br>
<input type="number" name="codePostal" placeholder="Code Postal">
<input type="text" placeholder="Ville" name="ville" >
</div>
<div>
<label>
Email:
</label>
<input type="email"name="email" required>
</div>
<div>
<label>
Mot De Passe:
</label>
<input type="password"name="MotPasse" required>
</div>
<input type="submit" value="OK" class="i">
</form>
<c:if test="${not empty requestScope.error}">
        <p style="color: red; text-align:center;"><c:out value="${requestScope.error}" /></p>
    </c:if>
</div>
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
.i{
width: 90px;}

</style>
</html>