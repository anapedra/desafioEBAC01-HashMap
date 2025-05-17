package org.anasantana.model;

public class BrowserPage {
    private final String url;
    private final String title;

    public BrowserPage(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " (" + url + ")";
    }
}
