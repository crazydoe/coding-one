package com.kurs.coding_one.collecitons.trees.binarySearchTree_withoutReductions;

public class Node<T extends Comparable<T>> {

    private Node right;
    private Node left;
    private T value;

    public Node(T value) {
        this.value = value;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public T getValue() {
        return value;
    }

    public int compare(T toCompare) {
        return value.compareTo(toCompare);
    }

    public Node<T> getRight() {
        return right;
    }

    public Node<T> getLeft() {
        return left;
    }
}
