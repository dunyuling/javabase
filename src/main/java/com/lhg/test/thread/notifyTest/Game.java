package com.lhg.test.thread.notifyTest;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Game implements Runnable {

    private Set<Athlete> players = new HashSet<>();
    private boolean start = false;

    public void addPlayer(Athlete one) {
        players.add(one);
    }

    public void removePlayer(Athlete one) {
        players.remove(one);
    }

    public Collection<Athlete> getPlayers() {

        return Collections.unmodifiableSet(players);
    }

    private int counter = 1;
    public void prepare(Athlete athlete) throws InterruptedException {
        System.out.println(athlete + " ready!");
        /*synchronized (this) {
            while (!start)
                wait();
            if (start)
                System.out.println(athlete + " go!" + " \t " + this.hashCode());
        }*/

        synchronized (this) {
            if(counter<players.size()) {
                counter++;
                wait();
            }else {
                System.out.println("go");
                go();
            }
            System.out.println(athlete+"go");

        }
    }

    public synchronized void go() {
        notifyAll();
    }

    public void ready() {
        for (Athlete athlete : getPlayers()) new Thread(athlete).start();
    }

    public void run() {
        start = false;
        System.out.println("Ready......");
        System.out.println("Ready......");
        System.out.println("Ready......");
        ready();
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        start = true;
//        System.out.println("Go!");
//        go();
    }

    public static void main(String[] args) {
        Game game = new Game();
        for (int i = 0; i < 10; i++)
            game.addPlayer(new Athlete(i, game));
        new Thread(game).start();
    }
}
