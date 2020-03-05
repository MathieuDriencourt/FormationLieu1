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
<form action="/FormationLieu1/ajoutflServlet" method = "post">
<select name = "idlieu">
<c:forEach items = "${listefl}" var = "lieu">
<option value = "${lieu.idLieu}">${lieu.ville}</option>
</c:forEach>
</select>
<input type = "submit" value = "valider">
<c:forEach items = "${listef1}" var = "listef">
<h3>${listef.theme}</h3>
</c:forEach>
</form>
</body>
</html>