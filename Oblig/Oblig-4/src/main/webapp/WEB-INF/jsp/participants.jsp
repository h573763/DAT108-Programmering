<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/styles.css" type="text/css">
    <title>Participants</title>
</head>
<body class="list-body">

<p>Logged in as: </p> <br/>
<p>Firstname: ${currentUser.firstName}</p> <br />
<p>Lastname: ${currentUser.lastname}</p> <br />
<p>Phonenumber: ${currentUser.phonenumber}</p> <br />

<table class="table">
    <jsp:useBean id="participants" scope="request" type="java.util.List"/>
    <c:forEach items="${participants}" var="person">
        <tr class="table-row">
                ${person.firstName} ${person.lastname} ${person.phonenumber} ${person.gender} <br/>
        </tr>
    </c:forEach>

</table>
<form action="participants" method="post">
    <button name = "logout" class="logout-button">Logg Out</button>
</form>
</body>

</html>