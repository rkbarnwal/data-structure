package com.rkb.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValidString("z(ab(cd)"));
        System.out.println(minRemoveToMakeValidString("z)a(b(cd)("));
        System.out.println(minRemoveToMakeValidString("z)a(b(cd)()"));
        System.out.println(minRemoveToMakeValidString("lee(t(c)o)de)"));
    }
    public static String minRemoveToMakeValidString(final String s) {
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> invalidIncides = new HashSet<>();
        char[] charArray = s.toCharArray();
        // Traverse the string to identify invalid parentheses
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i]=='(') {
                // Push the index of '(' onto the stack
                stack.push(i);
            } else if (charArray[i] == ')') {
                // Try to match with the top of the stack (opening parenthesis)
                if (!stack.empty()) {
                    stack.pop(); // Match found, remove the opening parenthesis index
                }
                else {
                    invalidIncides.add(i); // Unmatched ')', mark this index as invalid
                }
            }
        }
        // Any remaining '(' indices in the stack are unmatched
        while (!stack.empty()) {
            invalidIncides.add(stack.pop());
        }
        // Build the valid string by skipping invalid parentheses
        for (int i = 0; i < charArray.length; i++) {
            if (!invalidIncides.contains(i)) {
                sb.append(charArray[i]);
            }
        }
        return sb.toString();
    }
}
