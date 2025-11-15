/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.ejb.bl.GameFacadeLocal;

/**
 *
 * @author Obakeng
 */
public class PlayServlet extends HttpServlet {
    @EJB GameFacadeLocal bf1;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userChoice = request.getParameter("userChoice");
        
        String computerChoice = bf1.generateSign();
        String outcome = bf1.determineOutcome(userChoice, computerChoice);
        
        updateSession(session,userChoice,computerChoice,outcome);
        
        RequestDispatcher disp = request.getRequestDispatcher("outcome.jsp");
        disp.forward(request, response);
    }

    private void updateSession(HttpSession session, String userChoice, String computerChoice, String outcome) {
        Integer numGames = (Integer)session.getAttribute("numGames");
        Integer numGamesWonBySiri = (Integer)session.getAttribute("numGamesWonBySiri");
        Integer numGamesWonByPlayer = (Integer)session.getAttribute("numGamesWonByPlayer");
        Integer numGamesEndedTie = (Integer)session.getAttribute("numGamesEndedTie");
        List<String> listSiri = (List<String>)session.getAttribute("listSiri");
        List<String> listPlayer = (List<String>)session.getAttribute("listPlayer");
        
        if(outcome.equals("won"))
        {
            numGamesWonByPlayer++;
        }
        else if(outcome.equals("lost"))
        {
            numGamesWonBySiri++;
        }
        else if(outcome.equals("tie"))
        {
            numGamesEndedTie++;
        }
        numGames++;
        
        listSiri.add(userChoice);
        listPlayer.add(computerChoice);
        
        session.setAttribute("userChoice", userChoice);
        session.setAttribute("computerChoice", computerChoice);
        session.setAttribute("outcome", outcome);
        session.setAttribute("numGames", numGames);
        session.setAttribute("numGamesWonBySiri", numGamesWonBySiri);
        session.setAttribute("numGamesWonByPlayer", numGamesWonByPlayer);
        session.setAttribute("numGamesEndedTie", numGamesEndedTie);
        session.setAttribute("listSiri", listSiri);
        session.setAttribute("listPlayer", listPlayer);
    }



}
