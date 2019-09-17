package com.kurs.coding_one.collecitons.lists;

import com.kurs.coding_one.collecitons.lists.linkedList.DoublyLinkedList;

public class Test {

    public static void main(String... args) {
        System.out.println("DOUBLY LINKED LIST TEST:");
        customListTest(new DoublyLinkedList<>());
    }

    static void customListTest(List<String> list) {
        list.add("Lorem");
        list.add("ipsum");
        list.add("dolor");
        list.add("sit");
        list.add("amet");
        list.add("consecteur");

        System.out.println(list.get(4));
        System.out.println();

        Object[] strings = list.asArray();

        printArray(strings);

        list.remove("Lorem");
        list.remove("dolor");
        list.remove("consecteur");


        System.out.println();
        printArray(list.asArray());

        list.clear();
        printArray(list.asArray());

        list.add("Completely new word in cleared list");
        list.add("and another one");

        System.out.println();
        printArray(list.asArray());

        list.addBefore("and another one", "I'm here by mistake!");

        System.out.println();
        printArray(list.asArray());

        list.addAfter("and another one", "here we go again..");

        System.out.println();
        printArray(list.asArray());
    }

    static void printArray(Object[] array) {
        for (Object o : array) {
            System.out.println(o);
        }
    }
}
