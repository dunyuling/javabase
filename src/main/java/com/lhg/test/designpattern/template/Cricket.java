package com.lhg.test.designpattern.template;

/**
 * Created by liux on 16-3-19.
 */
public class Cricket extends Game {
    @Override
    void initial() {
        System.out.println("Cricket initial");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket startPlay");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket endPlay");
    }
}
