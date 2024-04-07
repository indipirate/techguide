package com.nayeem.dsa.hasmap;

import java.util.*;

public class Intersection {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> intersectList = new ArrayList<>();

        // Put elements of nums1 into the map
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Iterate through nums2, and if an element is found in nums1, add it to the intersection list
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                intersectList.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        // Convert the intersection list to an array
        int[] intersection = new int[intersectList.size()];
        for (int i = 0; i < intersectList.size(); i++) {
            intersection[i] = intersectList.get(i);
        }

        return intersection;
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
