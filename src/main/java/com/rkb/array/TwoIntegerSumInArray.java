package com.rkb.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoIntegerSumInArray {
    public static void main(String[] args) {
        System.out.println("UsingMap" + Arrays.toString(getIndicesMethod2(new int[]{1, 3, 5, 7, 9, 2}, 11)));
        System.out.println("UsingLoop" + Arrays.toString(getIndicesMethod1(new int[]{1, 3, 5, 7, 9, 2}, 11)));

        System.out.println("UsingMap" + Arrays.toString(getIndicesMethod2(new int[]{2,7,11,15}, 9)));
        System.out.println("UsingLoop" + Arrays.toString(getIndicesMethod1(new int[]{2,7,11,15}, 9)));

        System.out.println(Arrays.toString(getIndicesMethod2(null, 11)));
        System.out.println(Arrays.toString(getIndicesMethod2(new int[]{}, 11)));
    }

    // https://leetcode.com/problems/two-sum/description/
    public static int[] getIndicesMethod1(final int[] numbers, final int sum) {
        int numToFind = 0;
        for (int i = 0; i < numbers.length; i++) {
            numToFind = sum - numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                if (numToFind == numbers[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // https://leetcode.com/problems/two-sum/description/
    public static int[] getIndicesMethod2(final int[] numbers, final int sum) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int numToFind;
        if (numbers != null) {
            for (int i = 0; i < numbers.length; i++) {
                numToFind = sum - numbers[i];
                if (numMap.containsKey(numbers[i])) {
                    return new int[]{numMap.get(numbers[i]), i};
                } else {
                    numMap.put(numToFind, i);
                }
            }
        }
        return null;
    }
}
