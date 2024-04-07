package com.nayeem.dsa.stack;

public class MyStack {
    private int maxSize; // Maximum size of the stack
    private int[] stackArray; // Array to hold the stack elements
    private int top; // Index of the top element in the stack

    // Constructor to initialize the stack
    public MyStack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // Stack is initially empty
    }

    // Method to push an element onto the stack
    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push element.");
            return;
        }
        stackArray[++top] = element;
    }

    // Method to pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop element.");
            return -1; // Returning -1 to indicate stack underflow
        }
        return stackArray[top--];
    }

    // Method to peek at the top element of the stack
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; // Returning -1 to indicate stack underflow
        }
        return stackArray[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Method to display the elements of the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(5); // Creating a stack of size 5

        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.display(); // Stack: 10 20 30

        System.out.println("Popped element: " + myStack.pop()); // Popped element: 30
        myStack.display();
        System.out.println("Peeked element: " + myStack.peek()); // Peeked element: 20
        myStack.display(); // Stack: 10 20
    }
}
