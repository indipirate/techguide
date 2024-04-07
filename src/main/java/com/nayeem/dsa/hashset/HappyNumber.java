package com.nayeem.dsa.hashset;

import java.util.HashSet;

public class HappyNumber {
    public static boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    private static int getNext(int n) {
        int next = 0;
        while (n > 0) {
            int digit = n % 10;
            next += digit * digit;
            n /= 10;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19)); // Output: true
        System.out.println(isHappy(4));  // Output: false
    }
}
