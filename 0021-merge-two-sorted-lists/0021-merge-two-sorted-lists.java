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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
             // Create a dummy node to simplify edge cases (like empty list)
        // 'curr' will be our moving pointer to build the merged list
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // Traverse both lists until one becomes null
        while (list1 != null && list2 != null) {

            // Attach the smaller node to 'curr' and move that list forward
            if (list1.val <= list2.val) {
                curr.next = list1;   // Link smaller node
                list1 = list1.next;  // Move pointer forward in list1
            } else {
                curr.next = list2;   // Link smaller node
                list2 = list2.next;  // Move pointer forward in list2
            }

            // Move 'curr' forward in the merged list
            curr = curr.next;
        }

        // At this point, at least one list is null
        // Attach the remaining part of the other list (if any)
        curr.next = (list1 != null) ? list1 : list2;

        // Return the merged list starting from dummy.next
        return dummy.next;
    }
}