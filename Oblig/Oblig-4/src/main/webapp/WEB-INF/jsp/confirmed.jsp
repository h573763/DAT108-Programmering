<%--
  Created by IntelliJ IDEA.
  User: Torva
  Date: 02.11.2022
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="css/styles.css">
    <title>Confirmed</title>
</head>
<body>
    <h1>Confirmation</h1>
    <p>Confirmation is registered for: </p>
    <p>Firstname: ${newguest.firstName}</p>
    <p>Lastname: ${newguest.lastname} </p>
    <p>Phonenumber: ${newguest.phonenumber}</p>
    <p>Gender: ${newguest.gender}</p>

    <form action="confirmed" method="post">
        <button name = "viewList" class="button">View List</button>
    </form>
</body>
</html>
