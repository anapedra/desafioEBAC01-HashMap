package org.anasantana.service;

import org.anasantana.data_structure.DoublyLinkedList;
import org.anasantana.model.BrowserPage;
import org.anasantana.validetion.BrowserPageValidator;

public class BrowserHistoryService {

    private final DoublyLinkedList<BrowserPage> history = new DoublyLinkedList<>();

    public void visitPage(String url, String title) {
        BrowserPage page = new BrowserPage(url, title);
        BrowserPageValidator.validate(page);
        history.push(page);
    }

    public BrowserPage back() {
        return history.pop();
    }

    public BrowserPage currentPage() {
        return history.elementAt(history.size() - 1);
    }

    public int totalVisited() {
        return history.size();
    }

    public String printHistory() {
        return history.printList();
    }

    public BrowserPage pageAt(int index) {
        return history.elementAt(index);
    }

    public void removeAt(int index) {
        history.remove(index);
    }

    public void clearHistory() {
        while (!history.isEmpty()) {
            history.pop();
        }
    }
}
