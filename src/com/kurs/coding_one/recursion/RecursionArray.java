package com.kurs.coding_one.recursion;

public class RecursionArray {

    public static void main(String... args) {
        String[] array = {"COS", "INNE", "TROLOLO"};

        printArrayElement(0, array);
    }


    public static void printArrayElement(int index, String[] array) {
        if (index >= array.length) {
            return;
        }
        System.out.println(array[index]);
        printArrayElement(++index, array);
    }
}
