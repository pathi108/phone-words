package com.bgl.core.collections;

public class Node {
    private char letter;
    private boolean isEndOfWord;
    private Node left;
    private Node same;
    private Node right;

    public Node(char letter, boolean isEndOfWord, Node left, Node same, Node right) {
        this.letter = letter;
        this.isEndOfWord = isEndOfWord;
        this.left = left;
        this.same = same;
        this.right = right;
    }

    public char getLetter() {
        return letter;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public Node getLeft() {
        return left;
    }

    public Node getSame() {
        return same;
    }

    public Node getRight() {
        return right;
    }


    public void setLeft(Node left) {
        this.left = left;
    }

    public void setSame(Node same) {
        this.same = same;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}
