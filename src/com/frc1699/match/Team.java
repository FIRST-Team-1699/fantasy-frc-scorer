package com.frc1699.match;

import com.frc1699.event.Alliance;
import com.frc1699.main.Constants;
import com.frc1699.main.Utils;
import com.frc1699.parser.Parser;

import java.io.IOException;
import java.util.ArrayList;

public class Team {

    private final ArrayList<String> events;
    private final String teamNumber;
    private final ArrayList<Match> matches;
    private com.frc1699.event.Team team;

    public Team(final String teamNumber){
        this.teamNumber = teamNumber;
        this.matches = new ArrayList<>();
        this.events = new ArrayList<>();
        try {
            this.events.addAll(Parser.listParser((String) Utils.makeRequest(Utils.makeEventListReq(this))));
            this.matches.addAll(Parser.parseMatches((String) Utils.makeRequest(Utils.makeMatchListReq(this, this.getChampEvent()))));
            this.team = Parser.parseTeamStatus((String) Utils.makeRequest(Utils.makeTeamEventStatusRequest(this, this.getChampEvent())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getChampEvent(){
        for(String e : this.events){
            if(Constants.getInstance().getChampGameStrings().contains(e)){
                return e;
            }
        }
        return "None";
    }

    public int scoreMatches(){
        int totalScore = 0;
        for(Match m : this.matches){
            try {
                if(m.comp_level.equals("qm")){
                    totalScore += scoreQualMatch(m);
                }else if(m.comp_level.equals("qf")){
                    totalScore += scoreQFMatch(m);
                }else if(m.comp_level.equals("sf")){
                    totalScore += scoreSFMatch(m);
                }else if(m.comp_level.equals("f")){
                    totalScore += scoreFMatch(m);
                }
            }catch (NullPointerException e){
                System.err.println("Match not played yet.");
            }
        }
        totalScore += scoreAllianceSelection(getChampEvent());
        return totalScore;
    }

    private int scoreAllianceSelection(String event){
        try {
            Alliance alliance = team.alliance;
            int allianceNum = alliance.number;
            int pick = alliance.pick;
            int score = Constants.getInstance().getAllianceSelectionScoringGuide()[allianceNum - 1][pick];
            return score;
        }catch (NullPointerException e){
            return 0;
        }
    }

    private int scoreQualMatch(final Match m){
        int score = 0;
        String alliance = getAlliance(m);
        boolean surrogateMatch = false;
        for(String key : m.alliances.get(alliance).surrogate_team_keys){
            if(key.equals(getTBARequestID())){
                surrogateMatch = true;
                break;
            }
        }
        if (!surrogateMatch) {
            MatchResults results = m.score_breakdown.get(alliance);
            if (m.winning_alliance.equals(alliance)) {
                score += 3;
            }
            if (results.autoQuestRankingPoint) {
                score += 1;
            }
            if (results.faceTheBossRankingPoint) {
                score += 2;
            }
        }
        return score;
    }

    private int scoreQFMatch(final Match m){
        if(m.winning_alliance.contains(getTBARequestID())){
            return 6;
        }
        return 0;
    }

    private int scoreSFMatch(final Match m){
        if(m.winning_alliance.contains(getTBARequestID())){
            return 12;
        }
        return 0;
    }

    private int scoreFMatch(final Match m){
        if(m.winning_alliance.contains(getTBARequestID())){
            return 24;
        }
        return 18;
    }

    private int scoreEinsteinRRMatch(final Match m){
        if(m.winning_alliance.contains(getTBARequestID())){
            return 18;
        }
        return 0;
    }

    private int scoreEinsteinFMatch(final Match m){
        if(m.winning_alliance.contains(getTBARequestID())){
            return 60;
        }
        return 30;
    }

    private String getAlliance(Match match){
        for(String e : match.alliances.get("red").team_keys) {
            if(this.getTBARequestID().equals(e)){
                return "red";
            }
        }
        return "blue";
    }

    public String getTBARequestID(){
        return "frc" + teamNumber;
    }
    public String getTBAEventID(int index){
        return events.get(index);
    }
}
