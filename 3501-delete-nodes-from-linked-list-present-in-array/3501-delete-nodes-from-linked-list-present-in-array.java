class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Arrays.sort(nums); 

        ListNode dummy = new ListNode();
        ListNode prev = dummy, curr = head;

        while (curr != null) {
            if (!exists(nums, curr.val)) {
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }

        // terminate the list properly
        prev.next = null;

        return dummy.next;
    }

    private boolean exists(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;

            if (nums[mid] == target)
                return true;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}
