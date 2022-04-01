package com.frc1699.parser;

import com.frc1699.player.Player;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class PickParserTest {

    public static final String[] testData = {
            "Seth,Dustin,Joe D,Jakob,Nate,Jon,Madeline,Matt",
            "195,177,558,2767,2056,319,2337,2481",
            "1114,2451,217,67,2791,125,1241,1325",
            "27,2590,167,33,3357,176,5406,610",
            "133,302,533,225,5687,1796,3098,230",
            "1360,1918,340,1305,2202,5148,5460,870",
            "1718,25,190,694,4539,494,3452,3707",
            "4678,4003,272,2614,379,503,4917,1731",
            "469,303,236,623,868,3015,5172,2771"
    };

    @Test
    public void testPlayerParser(){
        Player[] players = Parser.parsePlayers(testData);
        System.out.println(Arrays.toString(players));
        HashSet<String> playerSet = new HashSet<>(List.of("Seth", "Dustin", "Joe D", "Jakob", "Nate", "Jon", "Madeline", "Matt"));
        for(Player player : players){
            assertTrue(playerSet.contains(player.getName()));
        }
        assertTrue(players[0].getTeamMap().containsValue(195));
        assertTrue(players[1].getTeamMap().containsValue(177));
        assertTrue(players[2].getTeamMap().containsValue(217));
        assertTrue(players[3].getTeamMap().containsValue(225));
        assertTrue(players[0].getTeamMap().containsValue(1114));
        assertTrue(players[0].getTeamMap().containsValue(27));
        assertTrue(players[0].getTeamMap().containsValue(133));
        assertTrue(players[0].getTeamMap().containsValue(1360));
        assertTrue(players[0].getTeamMap().containsValue(1718));
        assertTrue(players[0].getTeamMap().containsValue(4678));
        assertTrue(players[0].getTeamMap().containsValue(469));
    }
}
