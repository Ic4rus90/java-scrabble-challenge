package com.booleanuk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class Scrabble {
public String word;
public HashMap<Character, Integer> points = new HashMap<>();


    public Scrabble(String word) {
        this.word = word.toLowerCase();

        this.points.put('a', 1);
        this.points.put('b', 3);
        this.points.put('c', 3);
        this.points.put('d', 2);
        this.points.put('e', 1);
        this.points.put('f', 4);
        this.points.put('g', 2);
        this.points.put('h', 4);
        this.points.put('i', 1);
        this.points.put('j', 8);
        this.points.put('k', 5);
        this.points.put('l', 1);
        this.points.put('m', 3);
        this.points.put('n', 1);
        this.points.put('o', 1);
        this.points.put('p', 3);
        this.points.put('q', 10);
        this.points.put('r', 1);
        this.points.put('s', 1);
        this.points.put('t', 1);
        this.points.put('u', 1);
        this.points.put('v', 4);
        this.points.put('w', 4);
        this.points.put('x', 8);
        this.points.put('y', 4);
        this.points.put('z', 10);
    }


    public boolean isValid() {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < this.word.length(); i++) {
            if (Objects.equals(this.word.charAt(i), '{') | Objects.equals(this.word.charAt(i), '[')) {
                stack.push(this.word.charAt(i));
            }

            else if (Objects.equals(this.word.charAt(i), '}')) {
                if (Objects.equals(stack.peek(), '{')){
                    stack.pop();
                }
            }

            else if (Objects.equals(this.word.charAt(i), ']')) {
                if (Objects.equals(stack.peek(), '[')){
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public int score() {
        int score = 0;


        for (int i = 0; i < this.word.length(); i++){

            if(this.word.charAt(i) == ' ') {
                score += 0;
            }

            else if (points.containsKey(this.word.charAt(i))) {
                if (i == 0 || this.word.charAt(i-1) != '\\') {
                    score += points.get(this.word.charAt(i));
                }
            }
        }

        return score;
    }
}
