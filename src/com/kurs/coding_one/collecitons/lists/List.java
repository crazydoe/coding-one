package com.kurs.coding_one.collecitons.lists;

public interface List<T extends Comparable<T>> {

    void add(T object);

    T get(int index);

    boolean remove(T object);

    boolean addBefore(T before, T value);

    boolean addAfter(T after, T value);

    void clear();

    Object[] asArray();

    int size();
}
