package com.kurs.coding_one.collecitons.lists.linkedList;

public class Node<T> {
    private Node<T> previous;
    private Node<T> next;
    private T value;

    public Node(T value) {
        this.value = value;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }
}
