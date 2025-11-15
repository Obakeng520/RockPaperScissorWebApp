<%-- 
    Document   : view_all_statistics_outcome
    Created on : 23-May-2025, 22:07:20
    Author     : Obakeng
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entities.Game"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View All Statistics outcome Page</title>
    </head>
    <body>
        <h1>View All Statistics outcome</h1>
        <%
            List<Game> games = (List<Game>)session.getAttribute("games");
        %>
        <p>
            Below is the table:
        </p>
        <table border="1">
            
            <th>Name</th>
            <th>ID</th>
            <th>Number of games played between Siri and the player</th>
            <th>Number of games won by Siri</th>
            <th>Number of games won by the player</th>
            <th>Number of games that ended tie</th>
            <th>List of games signs made by Siri</th>
            <th>List of games signs made by the player.</th>
            <th>Timestamp</th>
            <%
                for(int i = 0; i <games.size(); i++)
                {
                    Game game = games.get(i);
                
                    Long id = game.getId();
                    String name = game.getName();
                    Integer numGames = game.getNumGames();
                    Integer numGamesWonBySiri = game.getNumGamesWonBySiri();
                    Integer numGamesWonByPlayer = game.getNumGamesWonByPlayer();
                    Integer numGamesEndeTie = game.getNumGamesEndedTie();
                    List<String> listSiri = game.getListSiri();
                    List<String> listPlayer = game.getListPlayer();
                    Date creationDate = game.getCreationDate();
                
            %>
            <tr>
                <td><%=name%></td>
                <td><%=id%></td>
                <td><%=numGames%></td>
                <td><%=numGamesWonBySiri%></td>
                <td><%=numGamesWonByPlayer%></td>
                <td><%=numGamesEndeTie%></td>
                <td>
                    <%
                        for(String player:listPlayer)
                        {
                            %>
                            <%=player%>
                            <%
                                }
                                
                    %>
                </td>
                <td>
                    <%
                        for(String siri:listSiri)
                        {
                            %>
                            <%=siri%>
                            <%
                                }
                                
                    %>
                </td>
                <td><%=creationDate%></td>
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
