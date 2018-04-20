package com.frc1699.main;

import com.frc1699.player.Player;

import java.util.ArrayList;

public class Game {

    private final ArrayList<Player> playerList;

    public Game() {
        this.playerList = new ArrayList<>();
    }

    public Game(final ArrayList<Player> playerList){
        this.playerList = playerList;
    }

    public Game(final Player[] playerList){
        this.playerList = new ArrayList<>();
        for(Player e : playerList) {
            this.playerList.add(e);
        }
    }

    public void addPlayer(final Player p){
        this.playerList.add(p);
    }

    public Player getPlayer(final int index){
        return this.playerList.get(index);
    }

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
