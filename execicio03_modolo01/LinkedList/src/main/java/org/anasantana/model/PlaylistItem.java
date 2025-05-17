package org.anasantana.model;

public class PlaylistItem {
    private String title;
    private String artist;

    public PlaylistItem(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + artist;
    }
}
