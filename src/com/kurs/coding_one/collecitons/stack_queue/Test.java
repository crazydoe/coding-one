package com.kurs.coding_one.collecitons.stack_queue;

public class Test {

    public static void main(String... args) {
        System.out.println("QUEUE TEST");
        testStackQueue(new Queue<>());

        System.out.println("\nSTACK TEST");
        testStackQueue(new Stack<>());
    }

    public static void testStackQueue(StackQueue<String> sq) {
        sq.push("Lorem");
        sq.push("ipsum");
        sq.push("dolor");
        sq.push("sit");
        sq.push("amet");
        sq.push("consecteur");
        print(sq);
    }

    public static void print(StackQueue<String> sq) {
        while (!sq.isEmpty()) {
            System.out.println(sq.pop());
        }
    }

}
