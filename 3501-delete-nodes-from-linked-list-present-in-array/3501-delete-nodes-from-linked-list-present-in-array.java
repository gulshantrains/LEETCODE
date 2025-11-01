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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> st = new HashSet<>();
        for (int num : nums)
            st.add(num);

        ListNode dummy = new ListNode();
        ListNode prev = dummy, curr = head;

        while (curr != null) {
            if (!st.contains(curr.val)) {
                prev.next = curr;
                prev = curr;
            }

            curr = curr.next;
        }
        // Important: terminate new list properly
        prev.next = null;
        
        return dummy.next;
    }
}