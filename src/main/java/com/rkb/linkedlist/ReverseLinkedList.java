package com.rkb.linkedlist;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        printLinkedList("Original List-> ", node1);
        System.out.println();
        printLinkedList("Reversed List-> ", reverseLinkedList(node1));
    }

    public static ListNode reverseLinkedList(final ListNode head) {
        ListNode currentNode = head;
        ListNode previous = null;
        while (currentNode != null) {
            ListNode next = currentNode.next; // Store next node
            currentNode.next = previous; // Reverse current node's pointer
            previous = currentNode; // Move prev and current one step forward
            currentNode = next;
        }
        return previous; // Move prev and current one step forward
    }

    public static void printLinkedList(final String message, final ListNode head) {
        ListNode currentNode = head;
        System.out.printf(message);
        while (currentNode != null) {
            System.out.printf(currentNode.getValue() + "->");
            currentNode = currentNode.next;
        }
    }
}
