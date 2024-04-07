package com.nayeem.dsa.hasmap;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public int findFirstNonRepeatingCharacter(String input) {
        Map<Character, Integer> countMap = new HashMap<>();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            if (countMap.containsKey(aChar)) {
                countMap.put(aChar, countMap.get(aChar) + 1);
            } else {
                countMap.put(aChar, 1);
            }
        }
        for(int i = 0; i< chars.length; i++){
            if(countMap.get(chars[i]) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstNonRepeatingCharacter firstNonRepeatingCharacter = new FirstNonRepeatingCharacter();
        int res1 = firstNonRepeatingCharacter.findFirstNonRepeatingCharacter("mom");
        System.out.println("First non Repeating Character index in Nayeem is "+ res1);
    }
    /*
    will also work for below
    public int findFirstNonRepeatingCharacter(String input) {
        int[] count = new int[256]; // Assuming ASCII characters
        char[] chars = input.toCharArray();

        // Count occurrences of each character
        for (char c : chars) {
            count[c]++;
        }

        // Find the first non-repeating character
        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i]] == 1) {
                return i;
            }
        }

        return -1;
    }
    */
}
