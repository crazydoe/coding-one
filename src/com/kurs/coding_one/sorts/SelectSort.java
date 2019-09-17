package com.kurs.coding_one.sorts;

import com.kurs.coding_one.sorts.utils.SortUtil;

public class SelectSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] array) {
        for (int margin = 0; margin < array.length; margin++) {
            int minIndex = findMinIndex(margin, array);
            SortUtil.swap(margin, minIndex, array);
        }
    }

    private int findMinIndex(int leftIndex, T[] array) {
        int minIndex = leftIndex;
        for (int i = leftIndex; i < array.length; i++) {
            if (array[minIndex].compareTo(array[i]) > 0) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
