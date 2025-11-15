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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Obakeng
 */
public class StartSessionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String name = request.getParameter("name");
        Long id = Long.parseLong(request.getParameter("id"));
        
        initializeSession(session,name,id);
        RequestDispatcher disp = request.getRequestDispatcher("play.jsp");
        disp.forward(request, response);
    }

    private void initializeSession(HttpSession session, String name, Long id) {
        Integer numGames = 0;
        Integer numGamesWonBySiri = 0;
        Integer numGamesWonByPlayer = 0;
        Integer numGamesEndedTie = 0;
        List<String> listSiri = new ArrayList<>();
        List<String> listPlayer = new ArrayList<>();
        
        session.setAttribute("name", name);
        session.setAttribute("id", id);
        session.setAttribute("numGames", numGames);
        session.setAttribute("numGamesWonBySiri", numGamesWonBySiri);
        session.setAttribute("numGamesWonByPlayer", numGamesWonByPlayer);
        session.setAttribute("numGamesEndedTie", numGamesEndedTie);
        session.setAttribute("listSiri", listSiri);
        session.setAttribute("listPlayer", listPlayer);
    }

}
