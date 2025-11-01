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
        // Set<Integer> st = new HashSet<>();
        // for (int num : nums)
        //     st.add(num);

        Arrays.sort(nums);

        ListNode dummy = new ListNode();
        ListNode prev = dummy, curr = head;

        while (curr != null) {
            int idx = Arrays.binarySearch(nums, curr.val);
            if (idx < 0) {
                prev.next = curr;
                prev = curr;
            }

            curr = curr.next;
        }
        //terminate new list properly
        prev.next = null;

        return dummy.next;
    }
}