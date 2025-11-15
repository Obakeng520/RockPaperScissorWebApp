<%-- 
    Document   : play
    Created on : 23-May-2025, 20:55:21
    Author     : Obakeng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Play Page</title>
    </head>
    <body>
        <h1>Session Started</h1>
        <%
            String computerName = pageContext.getServletContext().getInitParameter("computer_name");
            String name = (String)session.getAttribute("name");
        %>
        <p>
            Hi <b><%=name%></b>, this is <b><%=computerName%></b> let's play.
        </p>
        <form action="PlayServlet.do" method="POST">
            <table>
                <tr>
                    <td>Choose:</td>
                    <td>
                        <select name="userChoice">
                            <option value="Rock">Rock</option>
                            <option value="Paper">Paper</option>
                            <option value="Scissor">Scissor</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="SHOOT"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
