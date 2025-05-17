package org.anasantana.data_structure;

public class LinkedList<T> {


    private Node<T> head;
    private int size;

    // push: add to the end
    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // pop: remove and return from the end
    public T pop() {
        if (head == null) throw new IllegalStateException("List is empty");

        if (head.next == null) {
            T value = head.value;
            head = null;
            size--;
            return value;
        }

        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        T value = current.next.value;
        current.next = null;
        size--;
        return value;
    }

    // insert at index
    public void insert(int index, T value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        Node<T> newNode = new Node<>(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    // remove at index
    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        if (index == 0) {
            T value = head.value;
            head = head.next;
            size--;
            return value;
        }

        Node<T> prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        T value = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return value;
    }

    // get element at index
    public T elementAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public int size() {
        return size;
    }

    public String printList() {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        sb.append("[");
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }


}