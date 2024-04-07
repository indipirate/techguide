package com.nayeem.dsa.hashset;

import java.util.HashSet;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> jewelSet = new HashSet<>();
        for (char jewel : jewels.toCharArray()) {
            jewelSet.add(jewel);
        }
        
        int count = 0;
        for (char stone : stones.toCharArray()) {
            if (jewelSet.contains(stone)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        JewelsAndStones solution = new JewelsAndStones();

        // Example 1
        String jewels1 = "aA";
        String stones1 = "aAAbbbb";
        System.out.println("Output for Example 1: " + solution.numJewelsInStones(jewels1, stones1)); // Output: 3

        // Example 2
        String jewels2 = "z";
        String stones2 = "ZZ";
        System.out.println("Output for Example 2: " + solution.numJewelsInStones(jewels2, stones2)); // Output: 0
    }
}
