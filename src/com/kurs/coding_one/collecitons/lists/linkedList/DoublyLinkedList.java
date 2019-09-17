package com.kurs.coding_one.collecitons.lists.linkedList;

import com.kurs.coding_one.collecitons.lists.List;

import java.util.Optional;

public class DoublyLinkedList<T extends Comparable<T>> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    @Override
    public void add(T object) {
        Node<T> temporary = new Node<>(object);
        if (head == null && tail == null) {
            head = temporary;
            tail = temporary;
        } else {
            temporary.setPrevious(tail);
            tail.setNext(temporary);
            tail = temporary;
        }
        size++;
    }

    @Override
    public T get(int index) {
        Node<T> temporary = head;
        if (head == null) {
            return null;
        }

        if (index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        for (int i = 0; i < index; i++) {
            temporary = temporary.getNext();
        }

        return temporary.getValue();
    }

    @Override
    public boolean remove(T object) {
        if (head == null) {
            return false;
        }

        if (head == tail) {
            head = null;
            tail = null;
        }

        if (head.getValue().equals(object)) {
            head = head.getNext();
            head.setPrevious(null);
            size--;
            return true;
        }

        if (tail.getValue().equals(object)) {
            tail = tail.getPrevious();
            tail.setNext(null);
            size--;
            return true;
        }

        Optional<Node<T>> maybeNode = findNode(object);
        if (maybeNode.isPresent()) {
            Node<T> found = maybeNode.get();
            Node<T> previous = found.getPrevious();
            Node<T> next = found.getNext();
            previous.setNext(next);
            next.setPrevious(previous);
            size--;
            return true;
        }

        return false;
    }

    @Override
    public boolean addBefore(T before, T value) {
        Optional<Node<T>> maybeNode = findNode(before);
        if (maybeNode.isPresent()) {
            Node<T> found = maybeNode.get();
            Node<T> foundPrevious = found.getPrevious();
            Node<T> newNode = new Node<>(value);

            newNode.setNext(found);
            newNode.setPrevious(foundPrevious);
            found.setPrevious(newNode);
            if (found == head) {
                head = newNode;
            } else {
                foundPrevious.setNext(newNode);
            }
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAfter(T after, T value) {
        Optional<Node<T>> maybeNode = findNode(after);
        if (maybeNode.isPresent()) {
            Node<T> found = maybeNode.get();
            Node<T> foundNext = found.getNext();
            Node<T> newNode = new Node<>(value);

            newNode.setNext(foundNext);
            newNode.setPrevious(found);
            found.setNext(newNode);
            if (found == tail) {
                tail = newNode;
            } else {
                foundNext.setPrevious(newNode);
            }
            size++;
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    @Override
    public Object[] asArray() {
        if (head == null) {
            return new Object[0];
        }
        Object[] result = new Object[size];
        int i = 0;
        for (Node<T> x = head; x != null; x = x.getNext())
            result[i++] = x.getValue();
        return result;
    }

    @Override
    public int size() {
        return this.size;
    }

    private Optional<Node<T>> findNode(T value) {
        Node<T> temporary = head;
        while (temporary != null) {
            if (temporary.getValue().equals(value)) {
                return Optional.of(temporary);
            }
            temporary = temporary.getNext();
        }
        return Optional.empty();
    }
}