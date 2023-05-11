package com.example.song.controller;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s1 = "([]){}";
        String s2 = "(]";
        String s4 = "";
        String s7 = "([){]}";

        boolean res1 = solution(s1);
        boolean res2 = solution(s2);
        boolean res4 = solution(s4);
        boolean res7 = solution(s7);


        System.out.println("s1  : " + res1); // true
        System.out.println("s2  : " + res2); // false
        System.out.println("s4  : " + res4); // true
        System.out.println("s7  : " + res7); // true
    }
//    public static boolean solution(String s) {
//        Deque<Character> stack = new ArrayDeque<>();
//        for (char c : s.toCharArray()) {
//            if (c == '(' || c == '[' || c == '{') {
//                stack.push(c);
//            } else if (c == ')' || c == ']' || c == '}') {
//                if (stack.isEmpty() || stack.pop() != matchingBracket(c)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    static char matchingBracket(char c) {
//        return (c == ')' ? '(' : (c == ']' ? '[' : '{'));
//    }

    public static boolean solution(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.peek();
                    if ((c == ')' && top == '(') || (c == ']'
                            && top == '[') || (c == '}' && top == '{')) {
                        stack.pop();
                    } else {
                        for (int i = 0; i < stack.size(); i++) {
                            char start = stack.get(i);
                            if ((c == ')' && start == '(') || (c == ']'
                                    && start == '[') || (c == '}' && start == '{')) {
                                stack.remove(i);
                                break;
                            }
                        }
                    }
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
