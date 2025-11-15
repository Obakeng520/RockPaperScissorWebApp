<%-- 
    Document   : login_error
    Created on : 23-May-2025, 22:43:58
    Author     : Obakeng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Error Page</title>
    </head>
    <body>
        <h1>Login Error</h1>
        <p style="color: red;">
            Invalid details!! Please enter again.
        </p>
        <form action="j_security_check" method="POST">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="j_username"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="j_password"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="LOGIN"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
