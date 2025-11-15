/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.ejb.bl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.ac.tut.entities.Game;

/**
 *
 * @author Obakeng
 */
@Stateless
public class GameFacade extends AbstractFacade<Game> implements GameFacadeLocal {

    @PersistenceContext(unitName = "WeDoWebAppsEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GameFacade() {
        super(Game.class);
    }

    @Override
    public String generateSign() {
        String[] signs = {"Rock", "Paper", "Scissor"};
        int index = (int)Math.floor(Math.random()*3);
        return signs[index];
    }

    @Override
    public String determineOutcome(String userSign, String computerSign) {
        String outcome = "";
        
        if(userSign.equals(computerSign))
        {
            outcome = "tie";
        }
        if(userSign.equals("Rock") && computerSign.equals("Scissor"))
        {
            outcome = "won";
        }
        else if(userSign.equals("Paper") && computerSign.equals("Rock"))
        {
            outcome = "won";
        }
        else if(userSign.equals("Scissor") && computerSign.equals("Paper"))
        {
            outcome = "won";
        }
        else
        {
            outcome = "lost";
        }
        return outcome;
    }

    @Override
    public List<Game> viewAllGameStatistics() {
        Query query = em.createQuery("SELECT g FROM Game g");
        List<Game> games = query.getResultList();
        return games;
    }

    @Override
    public Game viewSpecificPlayer(Long id) {
        Query query = em.createQuery("SELECT g FROM Game g WHERE g.id = ?1");
        query.setParameter(1, id);
        Game game = (Game) query.getSingleResult();
        return game;
    }

    @Override
    public List<Game> viewPlayersWon() {
        Query query = em.createQuery("SELECT g FROM Game g WHERE g.numGamesWonByPlayer > g.numGamesWonBySiri");
        List<Game> games = query.getResultList();
        return games;
    }
    
}
