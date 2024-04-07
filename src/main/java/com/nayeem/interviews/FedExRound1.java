package com.nayeem.interviews;

public class FedExRound1 {
    public static void main(String[] args) {
        System.out.println(doDivide(1, 10));
    }

    public static int doDivide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            return 0;
        } finally {
            System.out.println("I am finally");
        }
    }
}
