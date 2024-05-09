package com.bgl.search;

import com.bgl.core.util.StringUtil;
import com.bgl.core.collections.Node;
import com.bgl.core.collections.TernarySearchTree;
import com.bgl.search.phone.NumberPad;

import java.util.ArrayList;
import java.util.List;

public class PhoneWordDictionary extends TernarySearchTree {

    List<String> result;

    public List<String> getPhoneWordsFor(String number) {
        result = new ArrayList<>();
        findPhoneWords(root, number, 0, "");
        return result;
    }

    private void findPhoneWords(Node node, String number, int index, String partialWord) {
        if (node == null) return;

        String digit = number.substring(index, index + 1);
        List<Character> assignedLetters = NumberPad.get(digit);


        for (char assignedLetter : assignedLetters) {
            Node nexNode = findFirstLetter(node, assignedLetter);
            if (nexNode != null && !StringUtil.containsMoreThanOneNumber(partialWord)) {
                char letter = nexNode.getLetter();
                if (isIndexWithinNumber(index, number.length())) {
                    int nextIndex = index + 1;
                    //When Find the next letter
                    findPhoneWords(nexNode.getSame(), number, nextIndex, partialWord + letter);
                    if (nexNode.isEndOfWord()) {
                        //When the found phone word is finished but the  number is still larger than it
                        findPhoneWords(root, number, nextIndex, partialWord + letter + "-");
                    }
                } else {
                    //When we completely match a number with phone words
                    if (nexNode.isEndOfWord()) {
                        collectResult(partialWord + node.getLetter(), number);
                    }
                }
            }


        }


        //When we cannot find letters for all numbers
        if (!result.contains(partialWord) && !StringUtil.containsMoreThanOneNumber(partialWord)) {
                //When the number is at the end
            if ((index == number.length() - 1) && StringUtil.endsWithAHyphen(partialWord)) {
                partialWord = StringUtil.leaveDigit(partialWord, digit);
                if (!StringUtil.containsMoreThanOneNumber(partialWord)) {
                    collectResult(partialWord, number);
                }
            } else {
                //when the number is in middle
                if (isIndexWithinNumber(index, number.length())) {
                    partialWord = StringUtil.leaveDigit(partialWord, digit) + '-';
                    findPhoneWords(root, number, index + 1, partialWord);
                }
            }
        }
    }


    private void collectResult(String result, String number) {
        String temp = result.replace("-", "");
        if (temp.length() == number.length()) {
            this.result.add(result);
        }
    }

    private boolean isIndexWithinNumber(int index, int numberLength) {
        return index < numberLength - 1;
    }


}
