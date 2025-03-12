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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        List<Integer> ls = new ArrayList<>();

        if (root == null) //If root is null return
            return ls;

        qu.add(root); //Add root

        while (!qu.isEmpty()) {
            int n = qu.size();

            TreeNode right = null; //Last node will be always viewed from righht

            while (n-- > 0) {
                TreeNode temp = qu.poll();
                right = temp;

                if (temp.left != null)
                    qu.add(temp.left);
                if (temp.right != null)
                    qu.add(temp.right);

            }
            ls.add(right.val);
        }
        return ls;
    }
}