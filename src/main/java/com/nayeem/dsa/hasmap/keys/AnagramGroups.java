package com.nayeem.dsa.hasmap.keys;

import java.util.*;

public class AnagramGroups {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = String.valueOf(charArray);
            
            if (!map.containsKey(sortedStr))
                map.put(sortedStr, new ArrayList<>());
            
            map.get(sortedStr).add(str);
        }
        
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        AnagramGroups anagramGroups = new AnagramGroups();
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = {""};
        String[] strs3 = {"a"};

        System.out.println(anagramGroups.groupAnagrams(strs1));
        System.out.println(anagramGroups.groupAnagrams(strs2));
        System.out.println(anagramGroups.groupAnagrams(strs3));
    }
}
