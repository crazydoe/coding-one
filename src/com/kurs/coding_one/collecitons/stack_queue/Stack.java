package com.kurs.coding_one.collecitons.stack_queue;

public class Stack<T> implements StackQueue<T> {

    private Node<T> top;
    private int size = 0;

    public void push(T value) {
        if (top == null) {
            top = new Node<>(value, null);
        } else {
            top = new Node<>(value, top);
        }
        size++;
    }

    public T pop() {
        Node<T> tmp = top;
        top = tmp.getNext();
        size--;
        return tmp.getValue();
    }

    public T peek() {
        return top.getValue();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
