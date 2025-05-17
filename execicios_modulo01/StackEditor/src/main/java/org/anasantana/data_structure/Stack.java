package org.anasantana.data_structure;

public class Stack<T> {
    private Node<T> top;
    private int size;

    // Push: adds an element to the top of the stack
    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Pop: removes and returns the top element of the stack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T value = top.value;
        top = top.next;
        size--;
        return value;
    }

    // Top: returns the top element without removing it
    public T top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.value;
    }

    public void desempilharTudo() {
        while (!isEmpty()) {
            T valor = pop();
            System.out.println("Desempilhando: " + valor);
        }
    }

    // isEmpty: checks if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // size: returns the number of elements in the stack
    public int size() {
        return size;
    }
}
