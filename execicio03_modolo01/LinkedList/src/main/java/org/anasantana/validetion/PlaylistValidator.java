package org.anasantana.validetion;

import org.anasantana.model.PlaylistItem;

public class PlaylistValidator {

    public static void validate(PlaylistItem item) {
        if (item == null || item.getTitle() == null || item.getTitle().isBlank()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        if (item.getArtist() == null || item.getArtist().isBlank()) {
            throw new IllegalArgumentException("Artist must not be empty");
        }
    }
}
