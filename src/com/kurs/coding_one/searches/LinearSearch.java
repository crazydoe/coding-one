package com.kurs.coding_one.searches;

public class LinearSearch<T> implements Search<T> {

    @Override
    public int find(T[] array, T key) {
        for (int index = 0; index < array.length; index++) {
            if(array[index].equals(key)) {
                return index;
            }
        }
        return -1;
    }
}
