package com.nayeem.interviews;

import java.util.HashMap;
import java.util.Map;

public class NewRelic {

    public static void main(String[] args) {
        String str1 = "ate";
        String str2 = "ant";
        printAnagram(str1, str2, isAnagram(str1, str2));
        printAnagram(str1, str2, isAnagram2(str1, str2));
    }

    static void printAnagram(String str1, String str2, boolean isAnagram) {
        System.out.println(str1 + ", " + str2 + " isAnagram? " + isAnagram);
    }

    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        Map<Character, Integer> countMap = new HashMap<>();
        for (Character c : a.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        for (Character c : b.toCharArray()) {
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) - 1);
            } else {
                return false;
            }
        }
        for (Integer count : countMap.values()) {
            if (count > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram2(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        char[] charCounts = new char[26];
        for (char c : str1.toCharArray()) {
            charCounts[c - 'a']++;
        }
        for (char c : str2.toCharArray()) {
            charCounts[c - 'a']--;
            if (charCounts[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
