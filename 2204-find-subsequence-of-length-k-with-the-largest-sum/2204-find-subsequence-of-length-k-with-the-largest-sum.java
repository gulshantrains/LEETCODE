class Solution {
    class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Pair> pq1 = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (int i = 0; i < nums.length; i++) {
            pq1.offer(new Pair(nums[i], i));

            if (pq1.size() > k)
                pq1.poll();

        }

        PriorityQueue<Pair> pq2 = new PriorityQueue<>((a, b) -> a.idx - b.idx);

        while (!pq1.isEmpty()) {
            pq2.offer(pq1.poll());
        }

        int[] result = new int[k];
        int i = 0;
        while (!pq2.isEmpty()) {
            result[i++] = pq2.poll().val;
        }

        return result;
    }
}