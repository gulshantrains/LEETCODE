/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
       List<Integer> ls=new ArrayList<>();
       helper(ls,root);
       return ls; 
    }
    public void helper(List<Integer> ls, TreeNode root) {
        if (root == null)
            return;

        helper(ls, root.left);
        helper(ls, root.right);
        ls.add(root.val);
    }
}