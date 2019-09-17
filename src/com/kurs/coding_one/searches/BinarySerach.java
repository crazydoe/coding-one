package com.kurs.coding_one.searches;

public class BinarySerach<T extends Comparable<T>> implements Search<T> {

    /*
        Ony for sorted arrays
     */
    @Override
    public int find(T[] array, T key) {
        return findRecursive(array, key, 0, array.length - 1);
    }

    private int findRecursive(T[] array, T key, int begin, int end) {
        int middle = (begin + end) / 2;

        if (end < begin) {
            return -1;
        }

        if (key == array[middle]) {
            return middle;
        }
        if (key.compareTo(array[middle]) < 0) {
            return findRecursive(array, key, begin, middle - 1);
        }
        return findRecursive(array, key, middle + 1, end);
    }

}
