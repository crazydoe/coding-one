package com.kurs.coding_one.sorts;

import java.util.Random;

public class Test {

    public static void main(String... args) {
        testSort(new BubbleSort<>());
        testSort(new QuickSort<>());
        testSort(new InsertionSort<>());
        testSort(new SelectSort<>());
        testSort(new QuickSortDif<>());
    }

    static void testSort(Sort<Integer> sort) {
        Integer[] numbers = createRandomArray(30);
        sort.sort(numbers);
        print(numbers);
    }

    static void print(Integer[] table) {
        for (int element : table) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static Integer[] createRandomArray(int size) {
        return new Random().ints(size, 10,1000).boxed().toArray(Integer[]::new);
    }
}
