package com.nayeem.dsa.hasmap;

import java.util.HashMap;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> reverseMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (map.containsKey(charS)) {
                if (map.get(charS) != charT) {
                    return false;
                }
            } else {
                map.put(charS, charT);
            }

            if (reverseMap.containsKey(charT)) {
                if (reverseMap.get(charT) != charS) {
                    return false;
                }
            } else {
                reverseMap.put(charT, charS);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "egg", t1 = "add";
        String s2 = "foo", t2 = "bar";
        String s3 = "paper", t3 = "title";

        System.out.println(isIsomorphic(s1, t1)); // Output: true
        System.out.println(isIsomorphic(s2, t2)); // Output: false
        System.out.println(isIsomorphic(s3, t3)); // Output: true
    }
}
