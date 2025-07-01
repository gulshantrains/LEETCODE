import java.util.Collection;
class Solution {
    public int[] p;
    public int[] r;

    private int find(int x) {
        if (x == p[x])
            return x;

        return p[x] = find(p[x]);
    }

    private void union(int x, int y) {
        int xp = find(x);
        int yp = find(y);

        if (xp == yp)
            return;

        if (r[xp] < r[yp]) {
            p[xp] = yp;
        } else if (r[xp] > r[yp]) {
            p[yp] = xp;
        } else {
            p[xp] = yp;
            r[yp]++;
        }

    }

    public long countPairs(int n, int[][] edges) {
        p = new int[n];
        r = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        for (int[] x : edges) {
            union(x[0], x[1]);
        }
        
        Map<Integer, Long> mp = new HashMap<>(); 
        
        for (int i = 0; i < n; i++) {
            // Corrected: Call find(i) to get the true representative
            mp.merge(find(i), 1L, Long::sum); // Use 1L for Long increment
        }
        
        long totalNodes = n; // This is sum of all component sizes, simply 'n'
        long ans = 0;

        Collection<Long> componentSizes = mp.values();
        
        for (Long size : componentSizes) {
            ans += (size * (totalNodes - size));
        }

        // Corrected: Divide by 2 because each pair is counted twice
        return ans / 2;
    }
}