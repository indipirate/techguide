package com.nayeem.dsa.hasmap;

import java.util.*;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        // Count the frequency of each element
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Create a min-heap
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );
        
        // Push elements into the heap
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            // If heap size exceeds k, pop the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // Extract the top k frequent elements from the heap
        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll().getKey();
        }
        
        return result;
    }

    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(nums1, k1)));  // Output: [1, 2]
        
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(nums2, k2)));  // Output: [1]
    }
}
