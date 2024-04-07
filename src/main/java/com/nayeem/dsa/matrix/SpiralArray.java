package com.nayeem.dsa.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralArray {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

//        int rows = matrix.length; // Returns 3
//        int columns = matrix[0].length; // Returns 4
//
//        System.out.println("rows:" + rows + ", columns:" + columns);
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                // Access matrix[i][j]
//                System.out.print(" (i:" + i + ",j:" + j + ") " + matrix[i][j] + "->");
//            }
//            System.out.println();
//        }
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse top row
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            // Traverse right column
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            // Traverse bottom row (if needed)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse left column (if needed)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SpiralArray sa = new SpiralArray();
        int[][] matrix = {{1, 2, 3, 4}, {4, 5, 6, 10}, {7, 8, 9, 3}, {17, 18, 29, 43}};
        sa.spiralOrder(matrix);
    }
}
