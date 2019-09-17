package com.kurs.coding_one.sorts;

public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] array) {

        int arraySize = array.length - 1;
        for (int actualIndex = arraySize; actualIndex >= 0; actualIndex--) {

            T temporary = array[actualIndex];
            int index = actualIndex + 1;

            while ((index <= arraySize) && (temporary.compareTo(array[index]) > 0)) {
                array[index - 1] = array[index];
                index++;
            }

            array[index - 1] = temporary;
        }
    }
}
