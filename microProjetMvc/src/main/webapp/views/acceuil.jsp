<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2><em>Bonjour Monsieur/Madame ${user.prenom} </em></h2>
<div class="line"></div>
<div class="links">
<div>
<a href="http://localhost:8080/microProjetMvc/CatalogueServlet">Consulter le catalogue</a>
</div>
<div>
<a href="http://localhost:8080/microProjetMvc/commandeServlet">Suivre vos commandes</a>
</div>
<div>
<a href="http://localhost:8080/microProjetMvc/views/panier.jsp">Visualiser votre panier</a>
</div>
</div>
</body>
<style>
.line {
border-top:1px solid grey;
margin:20px;
}
.links{
padding:20px;
}
.links div{
margin:20px;
}
h2{
margin:20px;
color:blue;
}
</style>
</html>
