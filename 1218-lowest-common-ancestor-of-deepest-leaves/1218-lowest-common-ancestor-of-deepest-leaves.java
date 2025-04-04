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
    HashMap<Integer,Integer> dp = new HashMap<>(); // Stores depth of each node value
    int maxD = 0; // Keeps track of maximum depth 

    
    public void depth(TreeNode root, int d){
        if(root == null) return;

        maxD = Math.max(maxD, d); 
        dp.put(root.val, d); // Store current node's depth

        depth(root.left, d + 1); 
        depth(root.right, d + 1);
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        depth(root, 0); // First, calculate depths of all nodes

        return LCA(root); // Now, find the Lowest Common Ancestor (LCA)
    }

    
    public TreeNode LCA(TreeNode root){
        // If node is null or node is at max depth, return it
        if(root == null || dp.get(root.val) == maxD) return root;

        TreeNode l = LCA(root.left); // Recurse for left subtree
        TreeNode r = LCA(root.right); // Recurse for right subtree

        // If both left and right are not null, current node is LCA
        if(l != null && r != null) return root;

        // Otherwise, return the non-null child
        return (l != null ? l : r);
    }
}
