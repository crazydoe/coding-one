package com.kurs.coding_one.sorts;

import com.kurs.coding_one.sorts.utils.SortUtil;

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] array) {
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    SortUtil.swap(i, i + 1, array);
                }
            }
        }
    }
}
