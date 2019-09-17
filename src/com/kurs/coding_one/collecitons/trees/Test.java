package com.kurs.coding_one.collecitons.trees;

import com.kurs.coding_one.collecitons.trees.binarySearchTree_withoutReductions.BinarySearchTree;
import com.kurs.coding_one.collecitons.trees.binarySearchTree_withoutReductions.Tree;

import java.util.List;

public class Test {

    public static void main(String... args) {
        Tree<Long> tree = new BinarySearchTree<>();
        tree.add(3L);
        tree.add(5L);
        tree.add(2L);
        tree.add(1L);
        tree.add(4L);
        tree.add(6L);
        tree.add(8L);
        List<Long> asList = tree.getAsList();
        asList.forEach(System.out::println);

        System.out.println("Does '8' exists in a tree? " + tree.exists(8L));

        System.out.println("value '3' removed? " + tree.remove(3L));

        System.out.println("Does '3' exists in a tree? " + tree.exists(3L));

        asList = tree.getAsList();
        asList.forEach(System.out::println);

    }
}
