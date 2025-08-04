class Solution {
    public int totalFruit(int[] A) {
        Map<Integer, Integer> mp = new HashMap<>();
        int left = 0, ans = 0, n = A.length;
        int temp = 0;

        for (int right = 0; right < n; right++) {
            mp.merge(A[right], 1, Integer::sum);
            temp++;

            while (mp.size() > 2) {
                mp.merge(A[left], -1, Integer::sum);

                if (mp.get(A[left]) <= 0)
                    mp.remove(A[left]);
                left++;
                temp--;
            }
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}
/*
Map<Integer, Integer> mp = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int x : fruits)
            mp.merge(x, 1, Integer::sum);

        for (var x : mp.entrySet()) {
            pq.offer(new int[] { x.getKey(), x.getValue() });

            if (pq.size() > 2)
                pq.poll();
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] x = pq.poll();

            ans += x[1];
        }
        return ans;
*/