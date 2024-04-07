package com.nayeem.dsa.hashset;

import java.util.HashSet;

public class ContainsDuplicate {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        int[] nums1 = {2, 2, 1};
        int[] nums2 = {4, 1, 2, 1, 2};
        int[] nums3 = {1};

        System.out.println(solution.singleNumber(nums1)); // Output: 1
        System.out.println(solution.singleNumber(nums2)); // Output: 4
        System.out.println(solution.singleNumber(nums3)); // Output: 1
    }
}
