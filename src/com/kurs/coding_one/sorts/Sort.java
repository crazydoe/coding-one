package com.kurs.coding_one.sorts;

public interface Sort<T extends Comparable<T>> {

    void sort(T[] array);
}
