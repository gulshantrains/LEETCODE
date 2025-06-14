class Solution {
    class Pair {
        int val;
        int color;

        Pair(int val, int color) {
            this.val = val;
            this.color = color;
        }
    }

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);

        Queue<Pair> qe = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                qe.offer(new Pair(i, 0));
                color[i] = 0;

                while (!qe.isEmpty()) {
                    Pair x = qe.poll();

                    int v = x.val;
                    int c = x.color;

                    for (int k : graph[v]) {
                        if (color[k] == -1) {
                            color[k] = 1 - c;

                            qe.offer(new Pair(k, 1 - c));
                        } else if (color[k] == c) {
                            return false;
                        }
                    }
                }
            }

        }
        return true;
    }
}