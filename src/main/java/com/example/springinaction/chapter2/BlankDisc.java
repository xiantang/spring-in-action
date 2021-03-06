package com.example.springinaction.chapter2;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> tracks;

    @Override
    public void playTrack(int trackNumber) {
        System.out.println(tracks.get(trackNumber));
    }

    public BlankDisc() {
    }

    public BlankDisc(String title, String artist, List<String> tracks) {
        this.tracks = tracks;
        this.title = title;
        this.artist = artist;
    }

    public BlankDisc(@Value("#{systemProperties['disc.title']") String title,
                     @Value("#{systemProperties['disc.artist']") String artist) {
        this.title = title;
        this.artist = artist;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }




    @Override
    public String play() {
        for(String track :tracks)
            System.out.println("-Track: "+track);
        return "Playing " + title + " by " + artist;
    }
}
