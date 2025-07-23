class Solution {
    class Pair {
        int node;
        int time;

        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int[] x : times) {
            int u = x[0], v = x[1], t = x[2];

            adj.get(u).add(new Pair(v, t)); //u--->v in time t (v,t)
        }

        Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        int[] tm = new int[n + 1];
        Arrays.fill(tm, Integer.MAX_VALUE);

        pq.offer(new Pair(k, 0));
        tm[k] = 0;

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();

            int u = temp.node;
            int ttm = temp.time;

            for (Pair neigh : adj.get(u)) {
                int v = neigh.node;
                int t = neigh.time;

                if (ttm + t < tm[v]) {
                    tm[v] = ttm + t;
                    pq.offer(new Pair(v, tm[v]));
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (tm[i] == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, tm[i]);
        }
        return ans;
    }
}