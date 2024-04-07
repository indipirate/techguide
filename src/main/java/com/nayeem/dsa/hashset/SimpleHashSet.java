package com.nayeem.dsa.hashset;

import java.util.LinkedList;
import java.util.List;

class SimpleHashSet<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private List<T>[] table;
    private int size;

    public SimpleHashSet() {
        this(DEFAULT_CAPACITY);
    }

    public SimpleHashSet(int capacity) {
        table = new LinkedList[capacity];
        size = 0;
    }

    private int hash(T element) {
        return Math.abs(element.hashCode() % table.length);
    }

    public void add(T element) {
        int index = hash(element);

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        if (!table[index].contains(element)) {
            table[index].add(element);
            size++;

            // Optionally, you can check if a resize is needed to maintain a low load factor
            if ((double) size / table.length > 0.75) {
                resize();
            }
        }
    }

    public boolean contains(T element) {
        int index = hash(element);

        return table[index] != null && table[index].contains(element);
    }

    public void remove(T element) {
        int index = hash(element);

        if (table[index] != null) {
            table[index].removeIf(e -> e.equals(element));
            size--;
        }
    }

    private void resize() {
        int newCapacity = table.length * 2;
        List<T>[] newTable = new LinkedList[newCapacity];

        for (List<T> bucket : table) {
            if (bucket != null) {
                for (T element : bucket) {
                    int newIndex = Math.abs(element.hashCode() % newCapacity);

                    if (newTable[newIndex] == null) {
                        newTable[newIndex] = new LinkedList<>();
                    }

                    newTable[newIndex].add(element);
                }
            }
        }

        table = newTable;
    }

    public static void main(String[] args) {
        SimpleHashSet<String> myHashSet = new SimpleHashSet<>();

        myHashSet.add("Apple");
        myHashSet.add("Banana");
        myHashSet.add("Orange");
        myHashSet.add("Apple"); // Duplicate element, won't be added

        System.out.println("HashSet contains 'Banana': " + myHashSet.contains("Banana"));

        myHashSet.remove("Orange");

        System.out.println("HashSet after removing 'Orange': " + myHashSet.contains("Orange"));
    }
}
