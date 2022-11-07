<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Participants</title>
</head>
<body>

<table>
    <jsp:useBean id="participants" scope="request" type="java.util.List"/>
    <c:forEach items="${participants}" var="person">
        <tr>
        ${person.firstName} ${person.lastname} ${person.phonenumber} ${person.gender}
        </tr>
    </c:forEach>

</table>

</body>

</html>