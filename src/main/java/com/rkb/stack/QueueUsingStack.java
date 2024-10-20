package com.rkb.stack;

import java.util.Stack;

public class QueueUsingStack {
    // Two stacks to implement the queue
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // Constructor to initialize the two stacks
    public QueueUsingStack() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    // Enqueue an element to the queue
    public void enqueue(Integer value) {
        // Always push new elements onto stack1
        this.stack1.push(value);
    }

    // Dequeue an element from the queue
    public Integer dequeue() {
        // If both stacks are empty, throw an exception (queue is empty)
        if (this.stack1.isEmpty() && this.stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        // If stack2 is empty, transfer all elements from stack1 to stack2
        if (stack2.empty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        // Pop from stack2 (which now contains elements in the correct order for dequeue)
        return stack2.pop();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Peek the front element of the queue
    public int peek() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        // If stack2 is empty, transfer all elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        // Peek the top of stack2
        return stack2.peek();
    }

    public static void main(String[] args) {
        QueueUsingStack queueUsingStack = new QueueUsingStack();
        queueUsingStack.enqueue(1);;
        queueUsingStack.enqueue(2);
        queueUsingStack.enqueue(3);

        System.out.println(queueUsingStack.dequeue());
        System.out.println(queueUsingStack.dequeue());

        // Enqueue more elements
        queueUsingStack.enqueue(4);
        queueUsingStack.enqueue(5);

        // Peek the front element
        System.out.println(queueUsingStack.peek());     // Output: 3

        // Dequeue remaining elements
        System.out.println(queueUsingStack.dequeue());  // Output: 3
        System.out.println(queueUsingStack.dequeue());  // Output: 4
        System.out.println(queueUsingStack.dequeue());  // Output: 5
    }
}
