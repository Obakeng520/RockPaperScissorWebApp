/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.ejb.bl.GameFacadeLocal;
import za.ac.tut.entities.Game;

/**
 *
 * @author Obakeng
 */
public class EndGameServlet extends HttpServlet {
    @EJB GameFacadeLocal bf1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("name");
        Long id = (Long)session.getAttribute("id");
        Integer numGames = (Integer)session.getAttribute("numGames");
        Integer numGamesWonBySiri = (Integer)session.getAttribute("numGamesWonBySiri");
        Integer numGamesWonByPlayer = (Integer)session.getAttribute("numGamesWonByPlayer");
        Integer numGamesEndedTie = (Integer)session.getAttribute("numGamesEndedTie");
        List<String> listSiri = (List<String>)session.getAttribute("listSiri");
        List<String> listPlayer = (List<String>)session.getAttribute("listPlayer");
        
        Game game = createGame(id,name,numGames,numGamesWonBySiri,numGamesWonByPlayer,numGamesEndedTie,listSiri,listPlayer);
        bf1.create(game);
        
        PrintWriter ou = response.getWriter();
        ou.print(name);
        ou.print(id);
        ou.print(numGames);
        ou.print(numGamesWonBySiri);
        ou.print(numGamesWonByPlayer);
        ou.print(numGamesEndedTie);
        ou.print(listSiri.get(0));
        ou.print(listPlayer.get(0));
        
        session.setAttribute("game", game);
        RequestDispatcher disp = request.getRequestDispatcher("summary.jsp");
        disp.forward(request, response);
        
    }

    private Game createGame(Long id, String name, Integer numGames, Integer numGamesWonBySiri, Integer numGamesWonByPlayer, Integer numGamesEndedTie, List<String> listSiri, List<String> listPlayer) {
        Game game = new Game();
        game.setId(id);
        game.setName(name);
        game.setNumGames(numGames);
        game.setNumGamesWonByPlayer(numGamesWonByPlayer);
        game.setNumGamesWonBySiri(numGamesWonBySiri);
        game.setNumGamesEndedTie(numGamesEndedTie);
        game.setListPlayer(listPlayer);
        game.setListSiri(listSiri);
        game.setCreationDate(new Date());
        return game;
    }



    

}
