class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int x : nums)
            pq.add(x);

        int m1 = pq.poll();
        int m2 = pq.poll();

        return (m1 - 1) * (m2 - 1);
    }
}