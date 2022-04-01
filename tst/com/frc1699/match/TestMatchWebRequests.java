package com.frc1699.match;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestMatchWebRequests {

    @Test
    public void testMatchRequest(){
        try {
            Match match = MatchCache.getInstance().getMatch("2022cada_qm63");
            assertEquals(match.match_number, 63);
            assertEquals(match.score_breakdown.get("red").totalPoints, 126);
            assertEquals(match.comp_level, "qm");
            assertEquals(match.computeScore("red"), 6);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
