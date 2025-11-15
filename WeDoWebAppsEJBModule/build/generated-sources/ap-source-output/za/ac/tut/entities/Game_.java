package za.ac.tut.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-23T22:28:27")
@StaticMetamodel(Game.class)
public class Game_ { 

    public static volatile SingularAttribute<Game, Integer> numGamesEndedTie;
    public static volatile SingularAttribute<Game, Integer> numGamesWonBySiri;
    public static volatile SingularAttribute<Game, Integer> numGamesWonByPlayer;
    public static volatile ListAttribute<Game, String> listPlayer;
    public static volatile SingularAttribute<Game, String> name;
    public static volatile SingularAttribute<Game, Long> id;
    public static volatile SingularAttribute<Game, Integer> numGames;
    public static volatile SingularAttribute<Game, Date> creationDate;
    public static volatile ListAttribute<Game, String> listSiri;

}