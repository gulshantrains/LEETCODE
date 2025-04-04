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
    HashMap<Integer,Integer> dp=new HashMap<>();
    int maxD=0;

    public void depth(TreeNode root, int d){
        if(root==null) return;

        maxD=Math.max(maxD,d);
        dp.put(root.val,d);

        depth(root.left, d+1);
        depth(root.right, d+1);
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        depth(root,0);

        return LCA(root);
    }
    public TreeNode LCA(TreeNode root){
        if(root==null || dp.get(root.val)==maxD) return root;

        TreeNode l=LCA(root.left);
        TreeNode r=LCA(root.right);

        if(l != null && r != null) return root;

        return (l != null ? l:r);
    }
}