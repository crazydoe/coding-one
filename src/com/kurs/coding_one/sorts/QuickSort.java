package com.kurs.coding_one.sorts;

import com.kurs.coding_one.sorts.utils.SortUtil;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(T[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);
            quickSort(array, begin, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }
    }

    private int partition(T[] array, int begin, int end) {
        T pivot = array[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                SortUtil.swap(i, j, array);
            }
        }

        swap(array, i + 1, end);
        return i + 1;
    }

    private void swap(T[] array, int index1, int index2) {
        T temporary = array[index1];
        array[index1] = array[index2];
        array[index2] = temporary;
    }
}
