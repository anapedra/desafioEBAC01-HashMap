package org.anasantana.service;

import org.anasantana.model.BrowserPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BrowserHistoryServiceTest {

    private BrowserHistoryService service;

    @BeforeEach
    void setUp() {
        service = new BrowserHistoryService();
    }

    @Test
    void shouldVisitPages() {
        service.visitPage("https://example.com", "Example");
        service.visitPage("https://openai.com", "OpenAI");

        assertEquals(2, service.totalVisited());
        assertEquals("OpenAI", service.currentPage().getTitle());
    }

    @Test
    void shouldReturnPageAtIndex() {
        service.visitPage("https://a.com", "A");
        service.visitPage("https://b.com", "B");

        assertEquals("A", service.pageAt(0).getTitle());
        assertEquals("B", service.pageAt(1).getTitle());
    }

    @Test
    void shouldBackToPreviousPage() {
        service.visitPage("https://1.com", "Page 1");
        service.visitPage("https://2.com", "Page 2");

        BrowserPage back = service.back();
        assertEquals("Page 2", back.getTitle());
        assertEquals(1, service.totalVisited());
    }

    @Test
    void shouldClearAllHistory() {
        service.visitPage("https://x.com", "X");
        service.visitPage("https://y.com", "Y");

        service.clearHistory();
        assertEquals(0, service.totalVisited());
    }

    @Test
    void shouldRemovePageAtIndex() {
        service.visitPage("https://a.com", "A");
        service.visitPage("https://b.com", "B");
        service.visitPage("https://c.com", "C");

        service.removeAt(1); // Remove B
        assertEquals(2, service.totalVisited());
        assertEquals("C", service.pageAt(1).getTitle());
    }
}
