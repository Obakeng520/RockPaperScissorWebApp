/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
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
public class ViewSecificPlayerServlet extends HttpServlet {
    @EJB GameFacadeLocal bf1;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Long id = Long.parseLong(request.getParameter("id"));
        
        Game game = bf1.viewSpecificPlayer(id);
        session.setAttribute("game", game);
        
        RequestDispatcher disp = request.getRequestDispatcher("view_specific_player_outcome.jsp");
        disp.forward(request, response);
        
    }

  

}
