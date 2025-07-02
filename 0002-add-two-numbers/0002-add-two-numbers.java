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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(); //Create a empty container node
        ListNode ans = temp; //Give one pointer to empty node
        int sum = 0, carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            sum = carry; //Give all Carry to Sum as it will be used in current iteration

            sum += (l1 != null) ? l1.val : 0; //Take value of l1 node
            sum += (l2 != null) ? l2.val : 0; //Value of l2 node

            int rem = sum % 10; //This will become node value
            carry = sum / 10;   //Will add in next

            temp.next = new ListNode(rem); //Add a node next to temp
            temp = temp.next; //Move pointer one step forward

            l1 = (l1 != null) ? l1.next : null; //Change l1 and l2 node
            l2 = (l2 != null) ? l2.next : null;
        }
        return ans.next;
    }
}