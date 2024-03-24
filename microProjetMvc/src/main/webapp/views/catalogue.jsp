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
<h1 style="text-align:center"><em>Catalogue</em></h1>
<form action="CatalogueServlet" method="get">
    <label>Choisissez le genre:</label>
  <select id="genreSelect" name="genre" onChange="this.form.submit()">
    <option value="">-- Choisissez un genre --</option>
    <c:forEach var="genre" items="${genres}">
        <option value="${genre}" ${param.genre == null ? '' : (genre eq param.genre ? 'selected' : '')}>${genre}</option>
    </c:forEach>
</select>

</form>
<br>
    <table>
        <thead>
            <tr>
                <th>Reference</th>
                <th>Designation</th>
                <th>Photo</th>
                <th>Prix</th>
                <th>Stock</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="article" items="${articles}">
                <tr>
					<td><a href="detailsServlet?codeArticle=${article.codeArticle}">${article.codeArticle}</a></td>
                    <td>${article.designation}</td>
                    <td><img src="${article.photo}" alt="Article Photo"></td>
                    <td>${article.stock}</td>
                    <td>${article.prix}</td>
                    <td><a href="panierServlet?articleId=${article.codeArticle}">Ajouter au panier</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
  <c:if test="${empty articles}">
    <p>Aucun article disponible dans cette catégorie pour le moment.</p>
</c:if>
</body>
<style>
   table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
        color:#ff00ae;
    }
    h1{
color:#f83e7b;
font-size:55px;
}

</style>
</html>