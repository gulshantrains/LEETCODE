/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;

        Queue<TreeNode> t1 = new LinkedList<>();
        Queue<TreeNode> t2 = new LinkedList<>();

        t1.offer(p);
        t2.offer(q);

        while (!t1.isEmpty() && !t2.isEmpty()) {
            TreeNode l1 = t1.remove();
            TreeNode r2 = t2.remove();

            if (l1 == null && r2 == null)
                continue;
            if (l1 == null || r2 == null)
                return false; // Structure difference

            if (l1.val != r2.val)
                return false;// Values are different

            t1.offer(l1.left);
            t1.offer(l1.right);

            t2.offer(r2.left);
            t2.offer(r2.right);
        }
        return true;
    }
}