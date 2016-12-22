<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>

    <body>
        <h2> Please, register </h2>
        <form method="post" action="register">
            <table cellpadding="5" cellspacing="5" style="border: 0px;">
            <tr>
             <td>Login</td>
             <td><input type="text" required name="login" pattern="[A-Za-z0-9]{2,}"/></td>
            </tr>
            <tr>
            <tr>
             <td>Password</td>
             <td><input type="password" required name="password" pattern="[A-Za-z0-9]{4,}"/></td>
            </tr>
            <tr>
             <td>Confirm Password</td>
             <td><input type="password" required name="repeatedPassword" pattern="[A-Za-z0-9]{4,}"/></td>
            </tr>
            </tr>
            <tr>
             <td>First Name</td>
             <td><input type="text" required name="firstName" pattern="[A-Za-z]{2,}" /></td>
            </tr>
            <tr>
             <td>Last Name</td>
             <td><input type="text" required name="lastName" pattern="[A-Za-z]{2,}"/></td>
            </tr>
            <tr>
              <td>Email</td>
              <td><input type="email" required name="email"></td>
            </tr>
            <tr>
             <td>Gender</td>
             <td><input type="radio" required name="sex" id="Male" value="Male"><label for="Male">Male</label>
             <input type="radio" required name="sex" id="Female" value="Female"><label for="Female">Female</label></td>
            </tr>
            <td><button type="submit">Submit</button></td>
        </table>
        </form>

        <br />
        <a href="home.jsp"> Home </a>
    </body>
</html>