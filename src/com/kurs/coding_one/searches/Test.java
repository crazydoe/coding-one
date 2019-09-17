package com.kurs.coding_one.searches;

import com.kurs.coding_one.sorts.QuickSort;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.Random;

public class Test {

    public static void main(String... args) {
        testSearch(new LinearSearch<>(), false);
        testSearch(new BinarySerach<>(), true);
    }

    static void testSearch(Search<Integer> search, boolean sorted) {
        Pair<Integer[], Integer> randomPair = createRandomArray(10);
        if (sorted) {
            new QuickSort<Integer>().sort(randomPair.getKey());
        }
        printArray(randomPair.getKey());

        int foundIndex = search.find(randomPair.getKey(), randomPair.getValue());
        System.out.println("value '" + randomPair.getValue() + "' found under index: " + foundIndex);
    }

    static Pair<Integer[], Integer> createRandomArray(int size) {
        Random random = new Random();
        Integer[] integers = random.ints(size, 10, 1000).boxed().toArray(Integer[]::new);
        Integer valueToFind = integers[random.nextInt(size - 1)];
        return new Pair<>(integers, valueToFind);
    }

    static void printArray(Integer[] array) {
        Arrays.stream(array).forEach(value -> System.out.println(value + " "));
        System.out.println();
    }
}
