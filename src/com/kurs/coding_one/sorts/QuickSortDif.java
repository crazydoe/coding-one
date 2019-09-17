package com.kurs.coding_one.sorts;

import com.kurs.coding_one.sorts.utils.SortUtil;

public class QuickSortDif<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(T[] array, int begin, int end) {
        T pivot = array[end];
        int j = begin;
        for (int i = begin; i < end; i++) {
            if (array[i].compareTo(pivot) < 0) { // array[i] < pivot
                SortUtil.swap(i, j, array);
                j++;
            }
        }
        array[end] = array[j];
        array[j] = pivot;

        if (begin < j - 1) {
            quickSort(array, begin, j - 1);
        }
        if (j + 1 < end) {
            quickSort(array, j + 1, end);
        }
    }
}
