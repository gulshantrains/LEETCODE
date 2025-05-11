class Solution {
    public int subarraysWithKDistinct(int[] A, int k) {
        return atMost(A, k) - atMost(A, k - 1);
    }

    public int atMost(int[] a, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        int i = 0, j = 0, cnt = 0;

        while (j < a.length) {
            mp.put(a[j], mp.getOrDefault(a[j], 0) + 1);

            while (mp.size() > k) {
                mp.put(a[i], mp.get(a[i]) - 1);

                if (mp.get(a[i]) == 0)
                    mp.remove(a[i]);
                i++;
            }
            cnt += (j - i + 1); //No of subArray with Atmost(0--K) k unique element
            j++;
        }
        return cnt;
    }
}