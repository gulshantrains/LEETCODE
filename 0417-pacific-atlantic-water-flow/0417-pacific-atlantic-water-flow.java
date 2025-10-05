class Solution {
    class Pair {
        int x, y;
        Pair(int x, int y) { this.x = x; this.y = y; }
    }

    public static int[][] dir = { {-1,0}, {0,1}, {1,0}, {0,-1} };

    public void bfs(int[][] hei, boolean[][] ocean) {
        int m = hei.length, n = hei[0].length;
        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(ocean[i][j])
                    q.offer(new Pair(i,j));
            }
        }

        while(!q.isEmpty()){
            Pair temp = q.poll();
            int x = temp.x, y = temp.y;

            for(int[] d : dir){
                int nx = x + d[0], ny = y + d[1];

                if(nx<0 || ny<0 || nx>=m || ny>=n) continue;
                if(ocean[nx][ny]) continue; //skip already visited
                if(hei[nx][ny] < hei[x][y]) continue;

                ocean[nx][ny] = true;
                q.offer(new Pair(nx, ny));
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] paci = new boolean[m][n];
        boolean[][] atla = new boolean[m][n];

        // Pacific borders
        for(int i=0;i<m;i++) paci[i][0] = true;
        for(int j=0;j<n;j++) paci[0][j] = true;

        // Atlantic borders
        for(int i=0;i<m;i++) atla[i][n-1] = true;
        for(int j=0;j<n;j++) atla[m-1][j] = true;

        bfs(heights, paci);
        bfs(heights, atla);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(paci[i][j] && atla[i][j])
                    ans.add(Arrays.asList(i,j));
            }
        }
        return ans;
    }
}
