<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
</head>
<body>

<h2>Login</h2>
    <form action="" method="post">
        <table>
        <c:if test="${error !=null }">
            <p style="color: red;">${error}</p>
        </c:if>
            <tr>
                <td><label for="username">Username</label></td>
                <td>:</td>
                <td><input type="text" id="username" name="username" required></td>
            </tr>
            <tr>
                <td><label for="password">Password</label></td>
                <td>:</td>
                <td><input type="password" id="password" name="password" required></td>
            </tr>
            <tr>
                <td><label for="remember_me">Remember Me?</label></td>
                <td></td>
                <td><input type="checkbox" name="remember_me"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">Login</button>
                </td>
            </tr>
        </table>
    </form>
    
</body>
</html>