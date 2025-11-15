<%-- 
    Document   : start
    Created on : 23-May-2025, 20:44:01
    Author     : Obakeng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start Session Page</title>
    </head>
    <body>
        <h1>Start Session</h1>
        <%
            String computerName = pageContext.getServletContext().getInitParameter("computer_name");
        %>
        <p>
            This is <b><%=computerName%></b>. Enter your name.
        </p>
        <form action="StartSessionServlet.do" method="POST">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name"/></td>
                </tr>
                <tr>
                    <td>ID:</td>
                    <td><input type="text" name="id"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="start"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
