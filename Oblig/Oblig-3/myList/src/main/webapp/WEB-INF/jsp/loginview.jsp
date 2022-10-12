<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./css/styles.css">
    </head>
    <body>

        <p>${redirectMessage}</p>
        <form action="${trylogin}" method="post">
            <fieldset>
                <legend>
                    Logg Inn
                </legend>
                Passord : <input type="password" name="password"/><br>
                <input type="submit" name="trylogin" value="Login"/><br>
            </fieldset>
        </form>

    </body>

</html>