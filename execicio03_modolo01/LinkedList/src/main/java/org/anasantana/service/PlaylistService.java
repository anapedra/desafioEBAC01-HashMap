package org.anasantana.service;

import org.anasantana.model.PlaylistItem;
import org.anasantana.data_structure.LinkedList;
import org.anasantana.validetion.PlaylistValidator;

public class PlaylistService {

    private final LinkedList<PlaylistItem> playlist = new LinkedList<>();

    public void addSong(String title, String artist) {
        PlaylistItem item = new PlaylistItem(title, artist);
        PlaylistValidator.validate(item);
        playlist.push(item);
    }

    public PlaylistItem removeLastSong() {
        return playlist.pop();
    }

    public void insertSongAt(int index, String title, String artist) {
        PlaylistItem item = new PlaylistItem(title, artist);
        PlaylistValidator.validate(item);
        playlist.insert(index, item);
    }

    public PlaylistItem getSongAt(int index) {
        return playlist.get(index);
    }

    public PlaylistItem removeSongAt(int index) {
        return playlist.remove(index);
    }

    public int size() {
        return playlist.size();
    }

    public String printPlaylist() {
        return playlist.printList();
    }
}
