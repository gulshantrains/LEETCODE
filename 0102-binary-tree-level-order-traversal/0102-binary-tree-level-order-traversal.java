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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();

        if (root == null)
            return ans;
        que.add(root);

        while (!que.isEmpty()) {
            int n = que.size();
            List<Integer> ls = new ArrayList<>(n);

            while (n-- > 0) {
                TreeNode temp = que.poll();

                ls.add(temp.val);

                if (temp.left != null)
                    que.add(temp.left);
                if (temp.right != null)
                    que.add(temp.right);
            }
            ans.add(ls);
        }
        return ans;
    }
}