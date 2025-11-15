<%-- 
    Document   : outcome
    Created on : 23-May-2025, 21:16:43
    Author     : Obakeng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Outcome Page</title>
    </head>
    <body>
        <h1>Outcome</h1>
        <%
            String computerName = pageContext.getServletContext().getInitParameter("computer_name");
            String name = (String)session.getAttribute("name");
            String userChoice = (String)session.getAttribute("userChoice");
            String computerChoice = (String)session.getAttribute("computerChoice");
            String outcome = (String)session.getAttribute("outcome");
        %>
        <table>
            <tr>
                <td><b><%=computerName%></b></td>
                <td><b><%=computerChoice%></b></td>
            </tr>
            <tr>
                <td><b><%=name%></b></td>
                <td><b><%=userChoice%></b></td>
            </tr>
            <tr>
                <td>Outcome:</td>
                <td><%=outcome%></td>
            </tr>
        </table>
            <p>
                Click <a href="play.jsp">here</a> to play again or click <a href="EndGameServlet.do">here</a> to view statistics.
            </p>
    </body>
</html>
