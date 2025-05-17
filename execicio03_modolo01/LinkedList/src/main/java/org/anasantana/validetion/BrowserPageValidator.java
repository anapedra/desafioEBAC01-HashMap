package org.anasantana.validetion;

import org.anasantana.model.BrowserPage;

public class BrowserPageValidator {
    public static void validate(BrowserPage page) {
        if (page == null || page.getUrl() == null || page.getUrl().isBlank()) {
            throw new IllegalArgumentException("Page must have a valid URL.");
        }
        if (page.getTitle() == null || page.getTitle().isBlank()) {
            throw new IllegalArgumentException("Page must have a valid title.");
        }
    }
}
