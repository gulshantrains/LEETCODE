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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> arr = new ArrayList<>();

        Queue<TreeNode> qu = new LinkedList<>();
        if (root != null)
            qu.add(root); // Put root in queue

        while (!qu.isEmpty()) {
            int level = qu.size();
            int curMax = Integer.MIN_VALUE; // get level at which we are working

            for (int i = 0; i < level; i++) {
                TreeNode node = qu.poll();
                curMax = Math.max(curMax, node.val);

                if (node.left != null)
                    qu.add(node.left);
                if (node.right != null)
                    qu.add(node.right);
            }

            arr.add(curMax);
        }
        return arr;

    }

}