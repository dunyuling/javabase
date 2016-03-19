package com.lhg.test.designpattern.template;

/**
 * Created by liux on 16-3-19.
 */
public abstract class Game {
    abstract void initial();

    abstract void startPlay();

    abstract void endPlay();

    //template method
    final void play() {
        initial();
        startPlay();
        endPlay();
    }


}
