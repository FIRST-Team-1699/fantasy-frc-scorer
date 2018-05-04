package com.frc1699.scoring;

import com.frc1699.match.Team;

import java.util.PriorityQueue;
import java.util.Queue;

public class Scorer implements Runnable {

    private static Scorer instance;

    public Scorer getInstance(){
        if(instance == null){
            instance = new Scorer();
        }
        return instance;
    }

    private boolean running = false;
    private Thread thread;
    private Queue<Team> scoringQueue;

    private Scorer(){
        scoringQueue = new PriorityQueue<>();
    }

    public void addTeamToScore(Team t){
        synchronized (scoringQueue){
            scoringQueue.add(t);
        }
    }

    @Override
    public void run() {
        while(running){
            synchronized (scoringQueue){
                scoringQueue.poll().scoreMatches();
            }
        }

        stop();
    }

    public synchronized void start(){
        if(running){
            return;
        }
        running = true;
        thread = new Thread();
        thread.start();
    }

    public synchronized void stop(){
        if(!running){
            return;
        }
        running = false;
        try{
            thread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
