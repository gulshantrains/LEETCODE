class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        boolean[] v = new boolean[n];
        int cnt=0;

        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);

                while (!q.isEmpty()) {
                    int x = q.poll();
                    v[x]=true;
                    for (int j = 0; j < n; j++) {
                        if(!v[j] && M[x][j]==1){
                            q.add(j);
                        }
                    }

                }
                cnt++;
            }
        }
        return cnt;
    }
}