package com.kurs.coding_one.collecitons.trees.binarySearchTree_withoutReductions;

import java.util.List;

public interface Tree<T extends Comparable<T>> {

    void add(T value);

    List<T> getAsList();

    boolean remove(T object);

    boolean exists(T object);

}
