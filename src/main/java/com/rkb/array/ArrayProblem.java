package com.rkb.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayProblem {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getIndices(new int[]{1, 3, 5, 7, 9, 2}, 11)));
    }

    public static int[] getIndices(final int[] numbers, final int sum) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int numToFind;
        for (int i = 0; i < numbers.length; i++) {
            numToFind = sum - numbers[i];
            if (numMap.containsKey(numbers[i])) {
                return new int[]{numMap.get(numbers[i]), i};
            } else {
                numMap.put(numToFind, i);
            }
        }
        return null;
    }
}
