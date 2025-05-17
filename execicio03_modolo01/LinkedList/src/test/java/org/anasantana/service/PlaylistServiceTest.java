package org.anasantana.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistServiceTest {

    private PlaylistService service;

    @BeforeEach
    void setUp() {
        service = new PlaylistService();
    }

    @Test
    void shouldAddAndRemoveSongs() {
        service.addSong("Song A", "Artist 1");
        service.addSong("Song B", "Artist 2");

        assertEquals(2, service.size());
        assertEquals("Song B", service.removeLastSong().getTitle());
        assertEquals(1, service.size());
    }

    @Test
    void shouldInsertSongAtPosition() {
        service.addSong("A", "X");
        service.addSong("C", "Y");
        service.insertSongAt(1, "B", "Z");

        assertEquals("B", service.getSongAt(1).getTitle());
        assertEquals(3, service.size());
    }

    @Test
    void shouldThrowOnInvalidInsert() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            service.addSong("", "Artist");
        });
        assertEquals("Title must not be empty", ex.getMessage());
    }

    @Test
    void shouldPrintFormattedPlaylist() {
        service.addSong("X", "ArtistX");
        service.addSong("Y", "ArtistY");
        String result = service.printPlaylist();
        assertTrue(result.contains("X") && result.contains("Y"));
    }
}
