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
            <c:forEach var="item" items="${list.items}">
                <tr>
                    <form action="/list" method="post">
                        <td>
                            <input type="hidden" value="${item}" name="item">
                            <input type="submit" value="Delete" name="button" style="padding: 5px">
                            ${item}
                        </td>
                    </form>
                </tr>
            </c:forEach>

        </table>

    </body>

</html>