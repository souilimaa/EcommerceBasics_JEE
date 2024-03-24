<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<h1><em>Détail de l'article</em></h1>
<form>
<div style="text-align: center;">
    <img src="${article.photo}" alt="articleImage">
</div>

<div>
<label><em>Référence:</em></label>
<input type="text" disabled value="${article.codeArticle }">
<label><em>Titre:</em></label>
<input type="text" value="${article.designation}" disabled>
</div>
<div>
<label><em>Quantité en stock:</em></label>
<input type="number" disabled value="${article.stock}">
<label>Pour le prix modique de:</label>
<input type="number" disabled value="${article.prix}" style="color:red;">
</div>
</form>
<a href="CatalogueServlet">retour</a>
<a href="">Ajouter au panier</a>
</div>
</body>
<style>
h1{
color:#f83e7b;
font-size:55px;
text-align:center
}
label{
color:blue;}
body{
display:flex;
justify-content:center;
}
input{
margin:20px;
}
a{
margin:20px;
float:left
}
</style>
</html>

