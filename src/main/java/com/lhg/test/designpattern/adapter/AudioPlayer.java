package com.lhg.test.designpattern.adapter;

/**
 * Created by liuhg on 16-2-18.
 */
public class AudioPlayer implements MediaPlayer {

    @Override
    public void play(String mediaType, String fileName) {
        if (mediaType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file.Name: " + fileName);
        } else {
            MediaPlayerAdapter mediaPlayerAdapter = new MediaPlayerAdapter(mediaType);
            mediaPlayerAdapter.play(mediaType,fileName);
        }
    }
}
