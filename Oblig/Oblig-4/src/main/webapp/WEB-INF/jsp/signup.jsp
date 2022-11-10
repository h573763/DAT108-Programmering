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
    <link rel="stylesheet" href="css/styles.css" type="text/css">
    <script src="js/script.js"></script>
    <title>Signup</title>
</head>
<body>
    <h2>Signup</h2>
    <form action="signup" method="post" class="signup-fieldset">
        <fieldset>
            <section>
                <label>Firstname: </label>
                <input type="text" name="firstname" id="firstname" onkeyup="nameValidator('firstname', 'fnameerror')" placeholder="Fill in firstname" class="signup-input" required="required">
                <p id="fnameerror" style="color: red;"></p>
            </section>
                <br>
            <section>
                <label>Lastname: </label>
                <input type="text" name="lastname" id="lastname" onkeyup="nameValidator('lastname', 'lnameerror')" placeholder="Fill in lastname" class="signup-input" required="required">
                <p id="lnameerror" style="color: red;"></p>
            </section>
                <br>
            <section>
                <label>Phone (8 digits): </label>
                <input type="text" name="phonenumber" id="phonenumber" onkeyup="phoneValidator()" placeholder="Fill in phonenumber" class="signup-input" required="required">
                <p id="numbererror" style="color: red;"></p>
                <p style="color: red;">${existing}${invalidlength}${invalidnumber}</p>
            </section>
                <br>
            <section>
                <label>Password: </label>
                <input type="password" name="password" id="pw" onkeyup="passwordValidator()" placeholder="Fill in password" class="signup-input" required="required">
                <p id="passwordError" style="color: red;"></p>
            </section>
                <br>
            <section>
                <label>Repeat password: </label>
                <input type="password" name="repeted" id="repeted" onkeyup="equalPassword()" placeholder="Repeat password" class="signup-input" required="required">
                <p style="color: red;">${mismatch}</p>
            </section>
                <br>
                <form class="radio">
                    <label>Gender: </label>
                    <input type="radio" id="male" name="gender" value="Male" required="required">
                    <label for="male">Male</label>
                    <input type="radio" id="female" name="gender" value="Female">
                    <label for="female">Female</label>
                </form>
            <br>
            <input type="submit" class="button" value="Sign me up"/>
        </fieldset>
    </form>
</body>
</html>
