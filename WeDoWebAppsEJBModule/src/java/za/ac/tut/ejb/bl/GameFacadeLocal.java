/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.ejb.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entities.Game;

/**
 *
 * @author Obakeng
 */
@Local
public interface GameFacadeLocal {

    void create(Game game);

    void edit(Game game);

    void remove(Game game);

    Game find(Object id);

    List<Game> findAll();

    List<Game> findRange(int[] range);
    String generateSign();
    String determineOutcome(String userSign, String computerSign);
    List<Game> viewAllGameStatistics();
    Game viewSpecificPlayer(Long id);
    List<Game> viewPlayersWon();

    int count();
    
}
