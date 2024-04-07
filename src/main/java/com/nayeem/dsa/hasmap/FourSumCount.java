package com.nayeem.dsa.hasmap;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        // Count all possible sums of nums1 and nums2
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum = num1 + num2;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // Iterate over nums3 and nums4 and find the complementary sums
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int target = -(num3 + num4);
                if (map.containsKey(target)) {
                    count += map.get(target);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FourSumCount solution = new FourSumCount();
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        System.out.println(solution.fourSumCount(nums1, nums2, nums3, nums4)); // Output: 2

        int[] nums5 = {0};
        int[] nums6 = {0};
        int[] nums7 = {0};
        int[] nums8 = {0};
        System.out.println(solution.fourSumCount(nums5, nums6, nums7, nums8)); // Output: 1
    }
}
