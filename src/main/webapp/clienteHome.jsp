<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cliente Home</title>
</head>
<body>
<% String nome= (String) session.getAttribute("nome"); 
String cognome= (String) session.getAttribute("cognome");
String username= (String) session.getAttribute("username");
%>
<h1>Benvenuto <% out.print(nome + " " + cognome + "! (username= " + username + ")");%>  </h1>

<br>

<h2><a href="logout">Logout</a></h2>

</body>
</html>