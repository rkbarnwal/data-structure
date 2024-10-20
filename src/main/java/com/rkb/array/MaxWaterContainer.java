package com.rkb.array;

public class MaxWaterContainer {
    public static void main(String[] args) {
        System.out.println(getMaxWaterContainer(new int[]{7, 1, 2, 3, 9}));
        System.out.println(getMaxWaterContainer(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(getMaxWaterContainer1(new int[]{7, 1, 2, 3, 9}));
        System.out.println(getMaxWaterContainer1(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(getMaxWaterContainer2(new int[]{7, 1, 2, 3, 9}));
        System.out.println(getMaxWaterContainer2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    // https://leetcode.com/problems/container-with-most-water/description/
    public static int getMaxWaterContainer(final int[] heights) {
        int area = 0;
        int l = 0, w = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int height = Math.min(heights[i], heights[j]);
                int width = j - i;
                int newArea = height * width;
                if (newArea > area) {
                    area = newArea;
                    l = i;
                    w = j;
                }
            }
        }
        System.out.println(String.format("Two Loops Length = %s, Width = %s and area = %s", heights[l], heights[w], area));
        return area;
    }

    // https://leetcode.com/problems/container-with-most-water/description/
    public static int getMaxWaterContainer1(final int[] heights) {
        int area = 0;
        int l = 0, w = 0;
        int endOfArray = heights.length -1;
        for (int i = 0; i < heights.length; i++) {
            int length = Math.min(heights[i], heights[endOfArray]);
            int width = endOfArray - i;
            int newArea = length * width;
            if (newArea > area) {
                area = newArea;
                l = i;
                w = endOfArray;
            }
        }
        System.out.println(String.format("One Loop Length = %s, Width = %s and area = %s", heights[l], heights[w], area));
        return area;
    }

    // https://leetcode.com/problems/container-with-most-water/description/
    public static int getMaxWaterContainer2(final int[] heights) {
        int area = 0;
        int startOfArray = 0, endOfArray = heights.length - 1;
        while (startOfArray < endOfArray) {
            int height = Math.min(heights[startOfArray], heights[endOfArray]);
            int width = endOfArray - startOfArray;
            int newArea = height * width;
            area = Math.max(newArea, area);
            if (heights[startOfArray] <= heights[endOfArray]) {
                startOfArray ++;
            }
            else {
                endOfArray --;
            }
        }
        System.out.println(String.format("One Loop area = %s", area));
        return area;
    }
}
