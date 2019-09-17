package com.kurs.coding_one.sorts.utils;

public class SortUtil {

    public static <T>void swap(int index1, int index2, T[] array) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
