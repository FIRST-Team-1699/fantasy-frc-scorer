package com.frc1699.main;

import com.frc1699.player.Player;

import java.util.ArrayList;

public class Game {

    //Stores players in the game
    private final ArrayList<Player> playerList;

    public Game() {
        this.playerList = new ArrayList<>();
    }

    public void addPlayer(final Player p){
        this.playerList.add(p);
    }

    //Returns player at given index
    public Player getPlayer(final int index){
        return this.playerList.get(index);
    }

    //Returns player with given name
    public Player getPlayer(final String name){
        for(Player e : this.playerList){
            if(name.equals(e.getName())){
                return e;
            }
        }
        return null;
    }

    public ArrayList<Player> getPlayerList(){
        return this.playerList;
    }
}
