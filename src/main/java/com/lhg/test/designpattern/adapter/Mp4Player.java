package com.lhg.test.designpattern.adapter;

/**
 * Created by liuhg on 16-2-18.
 */
public class Mp4Player implements AdvanceMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file.Name: " + fileName);
    }
}
