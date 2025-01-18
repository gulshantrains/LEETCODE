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
        int n = nums.length;

        PriorityQueue<Pair> pq1 = new PriorityQueue<>((a, b) -> b.val - a.val);
        PriorityQueue<Pair> pq2 = new PriorityQueue<>((a, b) -> a.idx - b.idx);

        for (int i = 0; i < n; i++) {
            pq1.add(new Pair(nums[i], i));
        }
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            Pair curr = pq1.poll();
            pq2.add(new Pair(curr.val, curr.idx));
        }
        
        for(int i=0; i<k; i++){
            ans[i]=pq2.poll().val;
        }
        return ans;
    }
}