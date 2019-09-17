package com.kurs.coding_one.collecitons.lists.arrayList;

import com.kurs.coding_one.collecitons.lists.List;

import java.util.Arrays;
import java.util.Optional;

public class ArrayList<T extends Comparable<T>> implements List<T> {

    private static final int INITIAL_CAPACITY = 10;
    private Object[] array;
    private int size = 0;

    public ArrayList(int size) {
        array = new Object[size];
    }

    public ArrayList() {
        array = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void add(T object) {
        checkRange();
        array[size++] = object;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public boolean remove(T object) {
        Optional<Integer> index = findObjectIndex(object);
        if (!index.isPresent()) {
            return false;
        }
        for (int i = index.get(); i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public boolean addBefore(T before, T value) {
        return false;
    }

    @Override
    public boolean addAfter(T after, T value) {
        return false;
    }

    @Override
    public void clear() {
        array = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public Object[] asArray() {
        Object[] arrayToReturn = new Object[size];
        for (int i = 0; i < size; i++) {
            arrayToReturn[i] = array[i];
        }
        return arrayToReturn;
    }

    @Override
    public int size() {
        return size;
    }

    public void checkRange() {
        if (array.length == size) {
            array = Arrays.copyOf(array, array.length + INITIAL_CAPACITY);
        }
    }

    public Optional<Integer> findObjectIndex(T object) {
        for (int i = 0; i < size; i++) {
            if (object.equals(array[i])) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }
}
