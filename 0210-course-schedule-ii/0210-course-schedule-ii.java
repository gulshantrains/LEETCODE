class Solution {
    private ArrayList<ArrayList<Integer>> adj;
    private int[] ind;

    public int[] findOrder(int nC, int[][] pre) {
        adj = new ArrayList<>(nC);
        ind = new int[nC];
        Arrays.fill(ind, 0);

        for (int i = 0; i < nC; i++) {
            adj.add(new ArrayList<>());
        }
        // [a,b]===> b----->a
        for (int[] e : pre) {
            int course = e[0];
            int prec = e[1];

            ind[course]++;
            adj.get(prec).add(course);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nC; i++) {
            if (ind[i] == 0)
                q.add(i);
        }
        int[] ans = new int[nC];
        int idx = 0;

        while (!q.isEmpty()) {
            int v = q.poll();
            ans[idx++] = v;

            for (int ne : adj.get(v)) {
                ind[ne]--;

                if (ind[ne] == 0)
                    q.add(ne);
            }
        }
        return (idx == nC) ? ans : new int[0];
    }
}