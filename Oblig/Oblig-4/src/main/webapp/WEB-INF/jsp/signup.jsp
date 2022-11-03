<%--
  Created by IntelliJ IDEA.
  User: Torva
  Date: 31.10.2022
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/index.css" type="text/css">
    <title>Signup</title>
</head>
<body>
    <h2>Signup</h2>
    <form action="signup" method="post" class="signup-fieldset">
        <fieldset>
            <section>
                <label>Firstname: </label>
                <input type="text" name="firstname" id="firstname" placeholder="Fill in firstname" class="signup-input">
            </section>
                <br>
            <section>
                <label>Lastname: </label>
                <input type="text" name="lastname" id="lastname" placeholder="Fill in lastname" class="signup-input">
            </section>
                <br>
            <section>
                <label>Phone (8 digits): </label>
                <input type="text" name="phonenumber" id="phonenumber" placeholder="Fill in phonenumber" class="signup-input">
            </section>
                <br>
            <section>
                <label>Password: </label>
                <input type="password" name="password" placeholder="Fill in password" class="signup-input">
            </section>
                <br>
            <section>
                <label>Repeat password: </label>
                <input type="password" name="repeted" placeholder="Repeat password" class="signup-input">
            </section>
                <br>
                <form class="radio">
                    <label>Gender: </label>
                    <input type="radio" id="male" name="gender" value="Male">
                    <label for="male">Male</label>
                    <input type="radio" id="female" name="gender" value="Female">
                    <label for="female">Female</label>
                </form>
            <br>
            <p>${existing}${mismatch}</p>
            <input type="submit" name="submit" value="Sign me up">
        </fieldset>
    </form>
</body>
</html>
