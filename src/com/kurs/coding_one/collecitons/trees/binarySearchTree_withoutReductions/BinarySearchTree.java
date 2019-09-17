package com.kurs.coding_one.collecitons.trees.binarySearchTree_withoutReductions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{

    private Node<T> root = null;

    @Override
    public void add(T value) {
        if (root == null) {
            root = new Node<>(value);
        } else {
            Optional<Node<T>> matchingParent = findMatchingParent(root, value);
            if (!matchingParent.isPresent()) {
                return;
            }
            Node<T> parent = matchingParent.get();
            if (parent.compare(value) == 1) {
                parent.setLeft(new Node<>(value));
            } else {
                parent.setRight(new Node<>(value));
            }
        }
    }

    @Override
    public boolean remove(T object) {
        if (root == null) {
            return false;
        }

        if (root.getValue().compareTo(object) == 0) {
            List<T> elementsToAdd = new LinkedList<>();
            inOrder(root.getLeft(), elementsToAdd);
            inOrder(root.getRight(), elementsToAdd);
            root = null;
            elementsToAdd.forEach(this::add);
            return true;
        }

        Optional<Node<T>> maybeParent = findParent(root, object);

        if (!maybeParent.isPresent()) {
            return false;
        }
        Node<T> parent = maybeParent.get();

        Node<T> toRemove;
        if (parent.getLeft() != null && parent.getLeft().compare(object) == 1) {
            toRemove = parent.getLeft();
            parent.setLeft(null);
        } else {
            toRemove = parent.getRight();
            parent.setRight(null);
        }

        List<T> elementsToAdd = new LinkedList<>();
        inOrder(toRemove.getLeft(), elementsToAdd);
        inOrder(toRemove.getRight(), elementsToAdd);

        elementsToAdd.forEach(this::add);
        return true;
    }

    @Override
    public List<T> getAsList() {
        List<T> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    @Override
    public boolean exists(T object) {
        Optional<Node<T>> maybeNode = findNode(root, object);
        return maybeNode.isPresent();
    }


    private Optional<Node<T>> findNode(Node<T> node, T value) {
        int result = node.compare(value);
        if (result == 0) {
            return Optional.of(node);
        }
        if (result == 1 && node.getLeft() != null) {
            return findNode(node.getLeft(), value);
        }
        if (result == -1 && node.getRight() != null) {
            return findNode(node.getRight(), value);
        }
        return Optional.empty();
    }


    private Optional<Node<T>> findMatchingParent(Node<T> parent, T value) {
        int result = parent.compare(value);
        if (result == 1) {
            if (parent.getLeft() != null) {
                return findMatchingParent(parent.getLeft(), value);
            }
            return Optional.of(parent);
        }
        if (result == -1) {
            if (parent.getRight() != null) {
                return findMatchingParent(parent.getRight(), value);
            }
            return Optional.of(parent);
        }
        return Optional.empty();
    }


    private Optional<Node<T>> findParent(Node<T> parent, T value) {
        Node<T> previous = null;
        Node<T> tmp = parent;

        while (tmp != null) {
            int compare = tmp.compare(value);
            if (compare == -1) {
                previous = tmp;
                tmp = tmp.getRight();

            }
            if (compare == 1) {
                previous = tmp;
                tmp = tmp.getLeft();
            }
            if (compare == 0) {
                return Optional.of(previous);
            }
        }
        return Optional.empty();
    }


    private void inOrder(Node<T> node, List<T> list) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft(), list);
        list.add(node.getValue());
        inOrder(node.getRight(), list);
    }
}
