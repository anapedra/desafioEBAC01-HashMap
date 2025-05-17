package org.anasantana.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistServiceComplexityTest {

    /*
     * O(n) – Precisa percorrer até o final da lista para adicionar.
     */
    @Test
    void testAddSongTimeComplexity() {
        PlaylistService service = new PlaylistService();
        for (int i = 0; i < 1000; i++) {
            service.addSong("Song " + i, "Artist");
        }

        long start = System.nanoTime();
        service.addSong("Last Song", "Artist");
        long end = System.nanoTime();
        System.out.println("addSong() O(n): " + (end - start) + " ns");
    }

    /*
     * O(n) – Precisa percorrer até o índice e mover os ponteiros.
     */
    @Test
    void testInsertSongAtTimeComplexity() {
        PlaylistService service = new PlaylistService();
        for (int i = 0; i < 1000; i++) {
            service.addSong("Song " + i, "Artist");
        }

        long start = System.nanoTime();
        service.insertSongAt(500, "Inserted", "Artist");
        long end = System.nanoTime();
        System.out.println("insertSongAt(index) O(n): " + (end - start) + " ns");
    }

    /*
     * O(n) – Remove o último elemento da lista (precisa andar até ele).
     */
    @Test
    void testRemoveLastSongTimeComplexity() {
        PlaylistService service = new PlaylistService();
        for (int i = 0; i < 1000; i++) {
            service.addSong("Song " + i, "Artist");
        }

        long start = System.nanoTime();
        service.removeLastSong();
        long end = System.nanoTime();
        System.out.println("removeLastSong() O(n): " + (end - start) + " ns");
    }
}
