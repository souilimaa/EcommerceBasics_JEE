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
<h1><em>Bienvenue ${user.prenom}, Votre commande a été enregister</em></h1>
<table>
        <thead>
            <tr>
                <th>Nombre d'articles dans le panier:</th>
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${empty sessionScope.cart}">
                    <tr>
                        <td class="empty-cart">Votre panier est vide suite à la commande</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td>${totalArticles}</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
    
<h2><em>Voici ta commande complète </em></h2>
 <h2>Liste des commandes</h2>
    <table>
        <thead>
            <tr>
                <th>Numéro de commande</th>
                <th>Article</th>
                <th>Quantité</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="ligneCommande" items="${commandes}">
                <tr>
                    <td>${ligneCommande.numCommande}</td>
                    <td>${ligneCommande.codeArticle}</td>
                    <td>${ligneCommande.qteCde}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
       <div><a href="CatalogueServlet">Vous pouvez commandez une autre Article</a></div>
		       <div><a href="views/acceuil.jsp">Vous pouvez aller a l'acceuil</a></div>
</div>
</body>
<style>
 table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
            color: #333;
        }
        h1{
color:#f83e7b;
font-size:55px;
text-align:center
}
body{
display:flex;
justify-content:center;
}
</style>
</html>