package com.frc1699.match;

import java.util.Map;

public class MatchResults {
   boolean activationBonusAchieved;
   int adjustedPoints;
   String autoBridgeState;
   int autoChargeStationPoints;
   String autoChargeStationRobot1;
   String autoChargeStationRobot2;
   String autoChargeStationRobot3;
   Map<String, String[]> autoCommunity;
   boolean autoDocked;
   int autoGamePieceCount;
   int autoGamePiecePoints;
   int autoMobilityPoints;
   int autoPoints;
   int coopGamePieceCount;
   boolean coopertitionCriteriaMet;
   String endGameBridgeState;
   int endGameChargeStationPoints;
   String endGameChargeStationRobot1;
   String endGameChargeStationRobot2;
   String endGameChargeStationRobot3;
   int endGameParkPoints;
   int foulCount;
   int foulPoints;
   int linkPoints;
   Link[] links;
   String mobilityRobot1;
   String mobilityRobot2;
   String mobilityRobot3;
   int rp;
   boolean sustainabilityBonusAchieved;
   int techFoulCount;
   Map<String, String[]> teleopCommunity;
   int teleopGamePieceCount;
   int teleopGamePiecePoints;
   int teleopPoints;
   int totalChargeStationPoints;
   int totalPoints;

   public static class Link{
      public int[] nodes;
      public String row;
   }
}
