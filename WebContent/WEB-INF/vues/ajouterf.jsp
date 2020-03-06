<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/FormationLieu1/ajoutfServlet" method = "post">
<input type = "text" name = "theme" placeholder = "Veuillez saisir le thème de la formation">
<select name = "lieu">
<c:forEach items = "${listefl}" var = "liste">
<option value = "${liste.idLieu}">${liste.ville}</option>
</c:forEach>
</select>
<input type = "submit" value = "valider">
</form>
</body>
</html>