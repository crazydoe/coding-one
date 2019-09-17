package com.kurs.coding_one.collecitons.stack_queue;

public interface StackQueue<T> {

    void push(T value);

    T pop();

    T peek();

    int size();

    boolean isEmpty();
}
