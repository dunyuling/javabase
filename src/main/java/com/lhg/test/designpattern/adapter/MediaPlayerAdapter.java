package com.lhg.test.designpattern.adapter;

/**
 * Created by liuhg on 16-2-18.
 */
public class MediaPlayerAdapter implements MediaPlayer {

    AdvanceMediaPlayer advanceMediaPlayer;

    public MediaPlayerAdapter(String mediaType) {
        if (mediaType.equalsIgnoreCase("vlc")) {
            advanceMediaPlayer = new VlcPlayer();
        } else if (mediaType.equalsIgnoreCase("mp4")) {
            advanceMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String mediaType, String fileName) {
        if(mediaType.equalsIgnoreCase("vlc")) {
            advanceMediaPlayer.playVlc(fileName);
        } else if (mediaType.equalsIgnoreCase("mp4")) {
            advanceMediaPlayer.playMp4(fileName);
        } else {
            System.out.println("Invalid media. " + mediaType + " format not supported");

        }

    }
}
