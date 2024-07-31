public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node and point it to the head of the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize two pointers, left starting at dummy and right at head
        ListNode left = dummy;
        ListNode right = head;

        // Move right pointer n steps ahead
        while (n > 0 && right != null) {
            right = right.next;
            n--;
        }

        // Move both pointers until right reaches the end of the list
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        // Remove the nth node from the end
        left.next = left.next.next;

        // Return the head of the modified list
        return dummy.next;
    }
}
