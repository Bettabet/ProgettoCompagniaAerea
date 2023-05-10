<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<body>
<h1>Benvenuto! Esegui il login o registrati</h1>

<h2>Login:</h2>
<form action="login" method="post">
Username:<input type="text" name="username"><br>
Password:<input type="password" name="password"><br>
<br>
<input type="submit" value="Login">
</form>

<br>

<h2>Registrati:</h2>
<form action="registrazione" method="post">
Nome:<input type="text" name="nome"><br>
Cognome:<input type="text" name="cognome"><br>
Username:<input type="text" name="username"><br>
Password:<input type="password" name="password"><br>
<br>
<input type="submit" value="Registrati">
</form>

</body>
</html>