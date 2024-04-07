package com.nayeem.dsa.hasmap;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChars {

    /**
     * Finds the length of the longest substring without repeating characters.
     *
     * @param s The input string.
     * @return The length of the longest substring without repeating characters.
     */
    public static int lengthOfLongestSubstring(String s) {
        // Check for null or empty string
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Length of the input string
        int n = s.length();

        // Variable to store the maximum length of substring
        int maxLength = 0;

        // Start and end pointers for the sliding window
        int start = 0;

        // Map to store the last index of each character in the string
        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        // Iterate through the string using the end pointer
        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);

            // If the current character is already in the substring, move the start pointer
            if (charIndexMap.containsKey(currentChar)) {
                // Move the start pointer to the next position after the repeated character
                start = Math.max(start, charIndexMap.get(currentChar) + 1);
            }

            // Update the character's index in the map
            charIndexMap.put(currentChar, end);

            // Update the maximum length
            maxLength = Math.max(maxLength, end - start + 1);
        }

        // Return the final result
        return maxLength;
    }

    public static void main(String[] args) {
        // Example usage
        String input = "abcabcbb";
        int result = lengthOfLongestSubstring(input);
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }
}
