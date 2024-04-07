package com.nayeem;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        printTriangle(5);
    }

    public static void printTriangle(int rows) {
        for (int i = rows; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" " + j);
            }
            for (int j = i; j > 0; j--) {

                System.out.print(" " + j);
            }
            System.out.println();
        }
    }
}