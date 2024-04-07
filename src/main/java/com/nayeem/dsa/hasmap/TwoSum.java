package com.nayeem.dsa.hasmap;

import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // Create a hashmap to store the indices of elements
        HashMap<Integer, Integer> numIndices = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement needed to reach the target
            int complement = target - nums[i];
            // Check if the complement exists in the hashmap
            if (numIndices.containsKey(complement)) {
                // If found, return the indices of the current element and its complement
                return new int[]{numIndices.get(complement), i};
            }
            // Otherwise, store the index of the current element in the hashmap
            numIndices.put(nums[i], i);
        }

        // If no solution is found, return an empty array
        return new int[0];
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("Output 1: [" + result1[0] + ", " + result1[1] + "]");

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Output 2: [" + result2[0] + ", " + result2[1] + "]");

        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSum(nums3, target3);
        System.out.println("Output 3: [" + result3[0] + ", " + result3[1] + "]");
    }
}
