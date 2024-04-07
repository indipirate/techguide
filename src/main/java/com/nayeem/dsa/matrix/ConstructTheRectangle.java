package com.nayeem.dsa.matrix;

public class ConstructTheRectangle {
    public static void main(String[] args) {
        ConstructTheRectangle constructTheRectangle = new ConstructTheRectangle();
        constructTheRectangle.constructRectangle(4);
    }

    public int[] constructRectangle(int area) {
        int[] res = new int[2];
        int diff = Integer.MAX_VALUE;
        for (int i = 1; i <= area; i++) {
            int length = area / i;
            System.out.println("[l,b]: [" + i + "," + length + "]");
            if (area == length * i) {
                if (i <= length) {
                    int diffLen = i - length;
                    if (diffLen < diff) {
                        diff = diffLen;
                        res[0] = i;
                        res[1] = length;
                    }
                }else {
                    break;
                }
            }
            System.out.println("[" + res[0] + "," + res[1] + "]");
        }
        return res;
    }
}
