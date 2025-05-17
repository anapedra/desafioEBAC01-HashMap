package org.anasantana.data_structure;

public class IntStack {
    private Node top;
    private int size;

    // Classe interna Node
    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.value;
    }

    public void desempilharTudo() {
        while (!isEmpty()) {
            int valor = pop();
            System.out.println("Desempilhando: " + valor);
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}
