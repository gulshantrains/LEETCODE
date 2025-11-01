class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        boolean[] exists = new boolean[100001]; // 1-indexed
        for (int x : nums)
            exists[x] = true;

        ListNode dummy = new ListNode();
        ListNode prev = dummy, curr = head;

        while (curr != null) {
            if (!exists[curr.val]) { // only keep if not in nums
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        prev.next = null; // terminate
        return dummy.next;
    }
}
