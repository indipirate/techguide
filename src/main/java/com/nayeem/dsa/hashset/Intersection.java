package com.nayeem.dsa.hashset;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class Intersection {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        
        for (int num : nums1) {
            set.add(num);
        }
        
        for (int num : nums2) {
            if (set.contains(num)) {
                intersect.add(num);
                // Remove the common element from nums1 so that duplicates are not considered
                set.remove(num);
            }
        }
        
        int[] result = new int[intersect.size()];
        int index = 0;
        for (int num : intersect) {
            result[index++] = num;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersection = intersection(nums1, nums2);
        for (int num : intersection) {
            System.out.print(num + " ");
        }
        System.out.println(); // Output: 2
        
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        intersection = intersection(nums3, nums4);
        for (int num : intersection) {
            System.out.print(num + " ");
        }
        System.out.println(); // Output: 9 4
    }
}
