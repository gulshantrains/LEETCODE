/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(); // A dummy node to simplify list construction
        ListNode current = dummyHead; // Pointer to the current node in the result list
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            // Add value from l1 if it exists
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add value from l2 if it exists
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Calculate digit for current node and new carry
            int digit = sum % 10;
            carry = sum / 10;

            // Create and append new node
            current.next = new ListNode(digit);
            current = current.next; // Move to the newly added node
        }

        return dummyHead.next; // The actual head of the result list
    }
}