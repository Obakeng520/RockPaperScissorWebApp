<%-- 
    Document   : access_denied
    Created on : 23-May-2025, 22:56:07
    Author     : Obakeng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Access Denied Page</title>
    </head>
    <body>
        <h1>Access denied</h1>
        <p style="color: red;">
            You are not authorized to access this page!!!
        </p>
        <p>
            Please click <a href="menu.jsp">here</a> to go back to the menu page.
        </p>
        <p>
            Please click <a href="index.html">here</a> to go back to the main page.
        </p>
        <p>
            Click <a href="LogoutServlet.do">here</a> to logout.
        </p>
    </body>
</html>
