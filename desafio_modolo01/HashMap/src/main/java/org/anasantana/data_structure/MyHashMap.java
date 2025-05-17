package org.anasantana.data_structure;

import java.util.LinkedList;
import java.util.Objects;

public class MyHashMap<K, V> {

    private static final int INITIAL_CAPACITY = 10;
    private static final float LOAD_FACTOR = 0.75f;

    private LinkedList<Node<K, V>>[] buckets;
    private int size;
    private int capacity;

    public MyHashMap() {
        this.capacity = INITIAL_CAPACITY;
        this.buckets = new LinkedList[capacity];
        this.size = 0;
    }

    private static class Node<K, V> {
        final K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int getBucketIndex(K key) {
        return Math.abs(Objects.hashCode(key)) % capacity;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        for (Node<K, V> node : buckets[index]) {
            if (Objects.equals(node.key, key)) {
                node.value = value;
                return;
            }
        }

        buckets[index].add(new Node<>(key, value));
        size++;

        if ((float) size / capacity > LOAD_FACTOR) {
            resize();
        }
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[index];

        if (bucket != null) {
            for (Node<K, V> node : bucket) {
                if (Objects.equals(node.key, key)) {
                    return node.value;
                }
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[index];

        if (bucket != null) {
            for (Node<K, V> node : bucket) {
                if (Objects.equals(node.key, key)) {
                    V value = node.value;
                    bucket.remove(node);
                    size--;
                    return value;
                }
            }
        }
        return null;
    }

    public void clear() {
        this.buckets = new LinkedList[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        LinkedList<Node<K, V>>[] newBuckets = new LinkedList[newCapacity];

        for (LinkedList<Node<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Node<K, V> node : bucket) {
                    int newIndex = Math.abs(Objects.hashCode(node.key)) % newCapacity;

                    if (newBuckets[newIndex] == null) {
                        newBuckets[newIndex] = new LinkedList<>();
                    }
                    newBuckets[newIndex].add(new Node<>(node.key, node.value));
                }
            }
        }

        this.buckets = newBuckets;
        this.capacity = newCapacity;
    }
}
