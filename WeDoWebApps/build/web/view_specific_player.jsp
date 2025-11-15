<%-- 
    Document   : view_specific_player
    Created on : 23-May-2025, 22:19:04
    Author     : Obakeng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Specific Player Page</title>
    </head>
    <body>
        <h1>View Specific Player Page</h1>
        <form action="ViewSecificPlayerServlet.do" method="POST">
            <table>
                <tr>
                    <td>ID:</td>
                    <td><input type="text" name="id"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="VIEW SPECIFIC PLAYER"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
