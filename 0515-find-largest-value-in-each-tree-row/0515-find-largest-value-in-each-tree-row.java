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
            qu.add(root);

        while (!qu.isEmpty()) {
            int level = qu.size();
            int[] a = new int[level];

            for (int i = 0; i < level; i++) {
                TreeNode node = qu.poll();
                a[i] = node.val;

                if (node.left != null)
                    qu.add(node.left);
                if (node.right != null)
                    qu.add(node.right);
            }
            int x = getMax(a);
            arr.add(x);
        }
        return arr;

    }

    private int getMax(int[] ar) {
        int max = ar[0];
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] > max) {
                max = ar[i];
            }
        }
        return max;
    }
}