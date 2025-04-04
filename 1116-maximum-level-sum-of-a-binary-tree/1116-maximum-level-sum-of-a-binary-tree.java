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
    public int maxLevelSum(TreeNode root) {
        if(root==null) return 0;

       Queue<TreeNode> qu=new LinkedList<>();
       qu.add(root);
       int depth=1;
       int ans=0,value=Integer.MIN_VALUE;

       while(!qu.isEmpty()){
        int n=qu.size();
        int temp=0;

        for(int i=0; i<n; i++){
            TreeNode cur=qu.poll();
            temp+=cur.val;

            if(cur.left != null) qu.add(cur.left);
            if(cur.right != null) qu.add(cur.right);
        }
        if(temp>value){
            value=temp;
            ans=depth;
        }
        depth++;
       }
       return ans;
    }
}