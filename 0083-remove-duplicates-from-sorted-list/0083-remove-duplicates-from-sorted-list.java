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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head, temp = head;

        while (cur != null && temp != null) {
            temp = temp.next;

            while (temp != null && cur.val == temp.val) {
                temp = temp.next;
            }
            cur.next = temp;
            cur = cur.next;

        }
        return head;
    }
}