<%-- 
    Document   : view_names_won_outcome
    Created on : 23-May-2025, 22:34:21
    Author     : Obakeng
--%>

<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entities.Game"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Names Won Page</title>
    </head>
    <body>
        <h1>Players Won</h1>
         <h1>View All Statistics outcome</h1>
        <%
            List<Game> games = (List<Game>)session.getAttribute("games");
        %>
        <p>
            Below is the table:
        </p>
        <table border="1">
            
            <th>Name</th>
           
            <%
                for(int i = 0; i <games.size(); i++)
                {
                    Game game = games.get(i);
                
                   
                    String name = game.getName();
                    
                
            %>
            <tr>
                <td><%=name%></td>
              
            </tr>
            <%
                }
            %>
        </table>
        <p>
                Please click <a href="LogoutServlet.do">here</a> to logout.
            </p>
    </body>
</html>
