package com.nayeem.dsa.hasmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSumCount2 {
    public List<int[]> fourSumCountIndices(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, List<int[]>> map1 = new HashMap<>();
        Map<Integer, List<int[]>> map2 = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        // Store indices along with sums of nums1 and nums2 in map1
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                if (!map1.containsKey(sum)) {
                    map1.put(sum, new ArrayList<>());
                }
                map1.get(sum).add(new int[]{i, j});
            }
        }

        // Store indices along with sums of nums3 and nums4 in map2
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum = nums3[i] + nums4[j];
                if (!map2.containsKey(sum)) {
                    map2.put(sum, new ArrayList<>());
                }
                map2.get(sum).add(new int[]{i, j});
            }
        }

        // Find complementary sums and store corresponding indices in result
        for (Map.Entry<Integer, List<int[]>> entry : map1.entrySet()) {
            int target = -entry.getKey();
            if (map2.containsKey(target)) {
                List<int[]> list1 = entry.getValue();
                List<int[]> list2 = map2.get(target);
                for (int[] indices1 : list1) {
                    for (int[] indices2 : list2) {
                        result.add(new int[]{indices1[0], indices1[1], indices2[0], indices2[1]});
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FourSumCount2 solution = new FourSumCount2();
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};

        List<int[]> indices = solution.fourSumCountIndices(nums1, nums2, nums3, nums4);
        for (int[] tuple : indices) {
            System.out.println("[" + tuple[0] + ", " + tuple[1] + ", " + tuple[2] + ", " + tuple[3] + "]");
        }
    }
}

