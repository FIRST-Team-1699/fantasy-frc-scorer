package com.frc1699.match;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TestMatchWebRequests {

    @Test
    public void testMatchRequest(){
        try {
            Match match = MatchCache.getInstance().getMatch("2023casj_qm80");
            assertEquals(match.match_number, 80);
            assertEquals(match.score_breakdown.get("red").totalPoints, 107);
            assertEquals(match.comp_level, "qm");
            assertEquals(match.computeScore("blue"), 6);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testScoreElimThrowsException(){
        try {
            Match elim = MatchCache.getInstance().getMatch("2023casj_f1m1");
            elim.computeScore("red");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testCreateTeam(){
        Team team = new Team("254");
    }
}
