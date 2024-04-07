package com.nayeem.dsa.hasmap;

import java.util.*;

public class MinimumIndexSum {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        for(int i =0; i < list1.length; i++){
            map.put(list1[i],i);
        }
        for(int j =0; j < list2.length; j++){
            if(map.containsKey(list2[j])){
                int sum = map.get(list2[j]) + j;
                if(sum < minSum){
                    result.clear();
                    result.add(list2[j]);
                    minSum = sum;
                }else if(sum == minSum){
                    result.add(list2[j]);
                }
            }
        }
    return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        MinimumIndexSum solution = new MinimumIndexSum();

        // Example 1
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] result1 = solution.findRestaurant(list1, list2);
        System.out.println("Example 1 Output: " + Arrays.toString(result1)); // Expected output: ["Shogun"]

        // Example 2
        String[] list3 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list4 = {"KFC", "Shogun", "Burger King"};
        String[] result2 = solution.findRestaurant(list3, list4);
        System.out.println("Example 2 Output: " + Arrays.toString(result2)); // Expected output: ["Shogun"]

        // Example 3
        String[] list5 = {"happy", "sad", "good"};
        String[] list6 = {"sad", "happy", "good"};
        String[] result3 = solution.findRestaurant(list5, list6);
        System.out.println("Example 3 Output: " + Arrays.toString(result3)); // Expected output: ["sad", "happy"]
    }
}
