class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int x : stones) {
            pq.add(x);
        }
        while (!pq.isEmpty()) {
            if(pq.size()==1) return pq.poll();
            int x = pq.poll();
            int y = pq.poll();

            if (x == y)
                continue;
            else {
                pq.add(x - y);
            }
            
        }
        return 0;
    }
}