package com.frc1699.main;

import com.frc1699.match.Team;
import com.frc1699.player.Player;

public class Main {

    public static void main(String[] args) {
        Constants.getInstance();

        Game g = new Game();
        g.addPlayer(new Player("Nate",
                new Team[]{new Team("254"),
                        new Team("16"),
                        new Team("1723"),
                        new Team("3476"),
                        new Team("2471"),
                        new Team("2630"),
                        new Team("1806"),
                        new Team("3478")}));
        g.addPlayer(new Player("Matt",
                new Team[]{new Team("973"),
                        new Team("1011"),
                        new Team("5499"),
                        new Team("968"),
                        new Team("5818"),
                        new Team("2478"),
                        new Team("1425"),
                        new Team("604")}));
        g.addPlayer(new Player("Madeline",
                new Team[]{new Team("971"),
                        new Team("1902"),
                        new Team("1986"),
                        new Team("1577"),
                        new Team("3489"),
                        new Team("1574"),
                        new Team("1690"),
                        new Team("624")}));
        g.addPlayer(new Player("Seth",
                new Team[]{new Team("148"),
                        new Team("330"),
                        new Team("180"),
                        new Team("4488"),
                        new Team("341"),
                        new Team("1296"),
                        new Team("2468"),
                        new Team("3310")}));
        g.addPlayer(new Player("Jon",
                new Team[]{new Team("118"),
                        new Team("359"),
                        new Team("604"),
                        new Team("1421"),
                        new Team("488"),
                        new Team("2352"),
                        new Team("4561"),
                        new Team("2046")}));
        g.addPlayer(new Player("Jakob",
                new Team[]{new Team("1678"),
                        new Team("1538"),
                        new Team("987"),
                        new Team("2848"),
                        new Team("842"),
                        new Team("1323"),
                        new Team("2642"),
                        new Team("3847")}));
        g.addPlayer(new Player("Dustin",
                new Team[]{new Team("179"),
                        new Team("1619"),
                        new Team("3309"),
                        new Team("5803"),
                        new Team("399"),
                        new Team("1477"),
                        new Team("744"),
                        new Team("1730")}));
        g.addPlayer(new Player("Greg",
                new Team[]{new Team("585"),
                        new Team("7134"),
                        new Team("846"),
                        new Team("6429"),
                        new Team("6050"),
                        new Team("1540"),
                        new Team("1868"),
                        new Team("3238")}));

        for(Player e : g.getPlayerList()){
            e.update();
            System.out.println(e.getName() + " : " + e.getScore());
        }
    }
}
