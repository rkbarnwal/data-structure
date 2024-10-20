package com.rkb.string;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("abcde"));
    }
    public static String reverseString(final String value) {
        char[] charArray = value.toCharArray();
        for (int i = 0, j = charArray.length-1; i < j; i++, j--) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        return new String(charArray);
    }
}
