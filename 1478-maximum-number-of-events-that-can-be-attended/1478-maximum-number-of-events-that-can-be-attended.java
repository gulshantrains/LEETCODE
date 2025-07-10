class Solution {
    public int maxEvents(int[][] E) {
        Arrays.sort(E, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 0, n = E.length, ans = 0;
        int days = E[0][0];

        while (!pq.isEmpty() || i < n) {
            if (pq.isEmpty())
                days = E[i][0];

            while (i < n && E[i][0] == days) {
                pq.offer(E[i][1]);
                i++;
            }
            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }
            days++;

            while (!pq.isEmpty() && pq.peek() < days) {
                pq.poll();
            }
        }
        return ans;
    }
}