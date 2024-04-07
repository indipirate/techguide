package com.nayeem.interviews;

import java.util.Arrays;

public class DeloitteRoundTwo {

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0};
        rearrangeArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void rearrangeArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Find the first occurrence of 1 from the left
            while (arr[left] == 0 && left < right) {
                left++;
            }
            // Find the first occurrence of 0 from the right
            while (arr[right] == 1 && left < right) {
                right--;
            }
            // Swap the elements if left < right
            if (left < right) {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
    }
}

