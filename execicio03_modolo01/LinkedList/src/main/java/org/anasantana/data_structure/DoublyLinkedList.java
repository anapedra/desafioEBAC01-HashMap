package org.anasantana.data_structure;

public class DoublyLinkedList<T> {

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        T value = tail.value;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return value;
    }

    public void insert(int index, T value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        Node<T> newNode = new Node<>(value);

        if (index == 0) {
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
            if (tail == null) tail = head;
        } else if (index == size) {
            push(value);
            return;
        } else {
            Node<T> current = nodeAt(index);
            Node<T> previous = current.prev;

            previous.next = newNode;
            newNode.prev = previous;
            newNode.next = current;
            current.prev = newNode;
        }

        size++;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<T> target = nodeAt(index);
        if (target == head) {
            head = target.next;
            if (head != null) head.prev = null;
        } else if (target == tail) {
            tail = target.prev;
            tail.next = null;
        } else {
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }

        size--;
        return target.value;
    }

    public T elementAt(int index) {
        return nodeAt(index).value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String printList() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) sb.append(" <-> ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private Node<T> nodeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }


    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current.value;
    }

}
