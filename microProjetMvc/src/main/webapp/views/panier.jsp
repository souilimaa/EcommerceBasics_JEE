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
<h1><em>Bienvenue ${user.prenom}, dans le panier</em></h1>
<h3><em>(votre panier)</em></h3>
 <table>
        <thead>
            <tr>
                <th>Article</th>
                <th>Quantité</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${cart}">
                <tr>
                    <td>${item.article.designation}</td>
                    <td>${item.quantity}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div>Total number of articles: <b><c:out value="${totalArticles}"></c:out></b> Article(s) </div>
    <div class="aa"><a href="CatalogueServlet">Vous pouvez commandez une autre Article</a>
    <br>
    <a href="commandeServlet">Vous pouvez enregistrer votre commande</a>
    </div>
        </div>
</body>
<style>
table {
        width: 80%;
        border-collapse: collapse;
        margin: 20px auto;
    }
    th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
    
    h1{
color:#f83e7b;
font-size:55px;
}
body{
display:flex;
justify-content:center;
}
div{
text-align:center;
}
.aa{
margin:20px;
}
</style>
</html>