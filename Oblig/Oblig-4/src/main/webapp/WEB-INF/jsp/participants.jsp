<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/styles.css" type="text/css">
    <title>Participants</title>
</head>
<body class="list-body">

<p>Logged in as: ${currentUser.phonenumber} / ${currentUser.firstName} ${currentUser.lastname}</p> <br />

<table class="table">
    <h2>Participants</h2>
    <jsp:useBean id="participants" scope="request" type="java.util.List"/>
    <tr>
        <th>Gender</th>
        <th>Name</th>
        <th>Phonenumber</th>
    </tr>
    <c:forEach items="${participants}" var="person">
        <tr>
            <th>${person.gender}</th>
            <th>${person.firstName} ${person.lastname}</th>
            <th>${person.phonenumber}</th>
        </tr>
    </c:forEach>

</table>
<form action="participants" method="post">
    <button class="button">Logg Out</button>
</form>
</body>

</html>