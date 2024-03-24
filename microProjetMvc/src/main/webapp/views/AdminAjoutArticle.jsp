<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un article</title>
</head>
<body>
     <h2>Ajouter un article</h2>
    <form action="" method="GET" >
        Désignation : <input type="text" name="designation"><br>
        Prix : <input type="text" name="prix"><br>
        Stock : <input type="text" name="stock"><br>
        Catégorie : <input type="text" name="categorie"><br>
        Photo : <input type="text" name="photo"><br>
        <input type="submit" value="Soumettre">
    </form>
    ${param.prix}

    <c:if test="${not empty param.designation and not empty param.prix and not empty param.stock and not empty param.categorie}">
        <sql:setDataSource var="myData" user="root" password="" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/microprojetcommerce"/>
    
        <sql:update dataSource="${myData}" var="result" >
            INSERT INTO `articles`(`Designation`, `Prix`, `Stock`, `Categorie`, `Photo`) VALUES (?, ?, ?, ?, ?)
            <sql:param value="${param.designation}" />
            <sql:param value="${param.prix}" />
            <sql:param value="${param.stock}" />
            <sql:param value="${param.categorie}" />
            <sql:param value="${param.photo}" />
        </sql:update>
    
        <c:if test="${result >= 1}">
            <p>Article ajouté avec succès.</p>
        </c:if>
        <c:if test="${result == 0}">
            <p>Échec de l'ajout de l'article.</p>
        </c:if>
        <c:if test="${result == -1}">
            <p>Une erreur s'est produite lors de l'ajout de l'article.</p>
        </c:if>
    </c:if>
</body>
</html>