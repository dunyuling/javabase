package com.lhg.test.designpattern.template;

/**
 * Created by liux on 16-3-19.
 */
public class Football extends Game {

    @Override
    void initial() {
        System.out.println("Football initial");
    }

    @Override
    void startPlay() {
        System.out.println("Football startPlay");
    }

    @Override
    void endPlay() {
        System.out.println("Football endPlay");
    }

}
