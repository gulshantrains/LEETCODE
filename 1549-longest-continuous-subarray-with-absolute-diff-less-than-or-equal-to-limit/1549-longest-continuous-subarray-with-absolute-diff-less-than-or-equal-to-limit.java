class Solution {
    public class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Pair> max = new PriorityQueue<>((a, b) -> b.val - a.val);
        PriorityQueue<Pair> min = new PriorityQueue<>((a, b) -> a.val - b.val);

        int n = nums.length;
        int j = 0, ans = 0;

        for (int i = 0; i < n; i++) {

            max.add(new Pair(nums[i], i));
            min.add(new Pair(nums[i], i));

            if (!max.isEmpty() && !min.isEmpty() &&
                    max.peek().val - min.peek().val > limit) {
                j = Math.min(max.peek().idx, min.peek().idx) + 1;

                while (max.peek().idx < j) {
                    max.poll();
                }
                while (min.peek().idx < j) {
                    min.poll();
                }

            }
            ans = Math.max(ans, i - j + 1);

        }
        return ans;
    }
}