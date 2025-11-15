/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;

/**
 *
 * @author Obakeng
 */
@Entity
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="ID")
    private Long id;
    @Column(name="NAME")
    private String name;
    @Column(name="NUMBER_OF_GAMES")
    private Integer numGames;
    @Column(name="NUMBER_OF_GAMES_WON_BY_SIRI")
    private Integer numGamesWonBySiri;
    @Column(name="NUMBER_OF_GAMES_WON_BY_PLAYER")
    private Integer numGamesWonByPlayer;
    @Column(name="NUMBER_OF_GAMES_ENDED_TIE")
    private Integer numGamesEndedTie;
    @ElementCollection
    @CollectionTable(name="Siri_Signs", joinColumns = @JoinColumn(name="id"))
    @Column(name="Signs_Siri")
    private List<String> listSiri;
    @ElementCollection
    @CollectionTable(name="Player_Signs", joinColumns = @JoinColumn(name="id"))
    @Column(name="Signs_Player")
    private List<String> listPlayer;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date creationDate;

    public Game() {
    }

    public Game(Long id, String name, Integer numGames, Integer numGamesWonBySiri, Integer numGamesWonByPlayer, Integer numGamesEndedTie, List<String> listSiri, List<String> listPlayer) {
        this.id = id;
        this.name = name;
        this.numGames = numGames;
        this.numGamesWonBySiri = numGamesWonBySiri;
        this.numGamesWonByPlayer = numGamesWonByPlayer;
        this.numGamesEndedTie = numGamesEndedTie;
        this.listSiri = listSiri;
        this.listPlayer = listPlayer;
        this.creationDate = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumGames() {
        return numGames;
    }

    public void setNumGames(Integer numGames) {
        this.numGames = numGames;
    }

    public Integer getNumGamesWonBySiri() {
        return numGamesWonBySiri;
    }

    public void setNumGamesWonBySiri(Integer numGamesWonBySiri) {
        this.numGamesWonBySiri = numGamesWonBySiri;
    }

    public Integer getNumGamesWonByPlayer() {
        return numGamesWonByPlayer;
    }

    public void setNumGamesWonByPlayer(Integer numGamesWonByPlayer) {
        this.numGamesWonByPlayer = numGamesWonByPlayer;
    }

    public Integer getNumGamesEndedTie() {
        return numGamesEndedTie;
    }

    public void setNumGamesEndedTie(Integer numGamesEndedTie) {
        this.numGamesEndedTie = numGamesEndedTie;
    }

    public List<String> getListSiri() {
        return listSiri;
    }

    public void setListSiri(List<String> listSiri) {
        this.listSiri = listSiri;
    }

    public List<String> getListPlayer() {
        return listPlayer;
    }

    public void setListPlayer(List<String> listPlayer) {
        this.listPlayer = listPlayer;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Game)) {
            return false;
        }
        Game other = (Game) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.entities.Game[ id=" + id + " ]";
    }
    
}
