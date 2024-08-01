/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find the length of the list and the tail node
        ListNode tail = head;
        int n;
        for (n = 1; tail.next != null; n++) {
            tail = tail.next;
        }
        
        // Form a circular list
        tail.next = head;
        
        // Find the new tail: (n - k % n - 1)th node
        k %= n;
        ListNode new_tail = head;
        for (int i = 0; i < n - k - 1; i++) {
            new_tail = new_tail.next;
        }
        
        // Find the new head
        ListNode new_head = new_tail.next;
        
        // Break the circle
        new_tail.next = null;
        
        return new_head;
    }
}
