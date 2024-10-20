package com.rkb.linkedlist;

public class CycleLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next = new ListNode(6);
        System.out.println("Before Creating ->" + detectCycle(node1));
        createCycle(node1, 3);
        System.out.println("After Creating ->" + detectCycle(node1));
    }

    // Helper method to create a cycle for testing
    private static void createCycle(ListNode head, int position) {
        if (head == null) return;
        ListNode curentNode = head;
        int count = 0;
        ListNode linkingNode = null;
        while (curentNode.next != null) {
            if (count == position) {
                linkingNode = curentNode;
            }
            curentNode = curentNode.next;
            count++;
        }
        // Create the cycle by pointing the last node to the cycleNode
        if (linkingNode != null) {
            curentNode.next = linkingNode;
        }
    }

    private static boolean detectCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
