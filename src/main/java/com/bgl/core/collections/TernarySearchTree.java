package com.bgl.core.collections;

public class TernarySearchTree {

    protected Node root;


    private Node insertLetter(Node node, char[] word, int index) {
        char current = word[index];
        if (node == null) {
            node = new Node(current, false, null, null, null);

        }
        if (current < node.getLetter())
            node.setLeft(insertLetter(node.getLeft(), word, index));
        else if (current > node.getLetter())
            node.setRight(insertLetter(node.getRight(), word, index));
        else {
            if ((index + 1 < word.length)) {
                node.setSame(insertLetter(node.getSame(), word, ++index));
            } else {
                node.setEndOfWord(true);
            }
        }
        return node;
    }

    public Node getRoot(){
        return root;
    }
    public void insert(String word) {

        root = insertLetter(root, word.toCharArray(), 0);
    }

    public Node findFirstLetter(Node node, char letter) {
        if (node != null) {
            if (letter < node.getLetter()) {
                return findFirstLetter(node.getLeft(), letter);
            } else if (letter > node.getLetter()) {
                return findFirstLetter(node.getRight(), letter);
            } else if (letter == node.getLetter()) {
                return node;
            }
        }
        return null;
    }
}
