<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <p>${login}</p>

    <form action="requestlogin" method="post" style="padding: 10px">
            User : <input type="text" name="user" style="margin: 20px">
            <br />
            Passord : <input type="password" name="password"/>
            <br />
            <input type="submit" value="Login" style="margin: 5px"/>
    </form>

    </body>

</html>