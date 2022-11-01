<%--
  Created by IntelliJ IDEA.
  User: Torva
  Date: 31.10.2022
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/index.css" type="text/css">
    <title>Login</title>
</head>
<body>
    <div id="root">
        <p>${message}</p>
        <form action="login" method="post">
            <fieldset>
                <legend>
                   Login
                </legend>
                <input type="text" name="phonenumber" placeholder="Phonenumber">
                <input type="password" name="password" placeholder="Password">
                <br>
                <input type="submit" value="Login" name = "button">
            </fieldset>
        </form>
        <a href="signup">
            Click here to sign up
        </a>
    </div>
</body>
</html>
