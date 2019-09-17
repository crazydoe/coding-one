package com.kurs.coding_one.collecitons.stack_queue;

public class Queue<T> implements StackQueue<T> {
    private Node<T> back;
    private Node<T> front;
    private int size = 0;

    public void push(T value) {
        if (back == null && front == null) {
            back = new Node<>(value);
            front = back;
        } else {
            Node<T> tNode = new Node<>(value);
            back.setNext(tNode);
            back = tNode;
        }
        size++;
    }

    public T pop() {
        Node<T> tmp = front;
        front = front.getNext();
        if (front == null) {
            back = null;
        }
        size--;
        return tmp.getValue();
    }

    public T peek() {
        return front.getValue();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return back == null && front == null;
    }
}
