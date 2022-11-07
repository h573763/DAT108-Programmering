<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>MyList</title>
</head>
<body>
<h1>Welcome <c:out value="${user}"/>, to MyList!</h1>
<form action="/list" method="post">
    <input type="submit" value="Add" name="button"><br />
    <input type="text" name="item">
</form>
<table>
    <jsp:useBean id="participants" scope="request" type="java.util.List"/>
    <c:forEach items="${participants}" var="item">
        ${item.firstName}<br>
    </c:forEach>

</table>

</body>

</html>