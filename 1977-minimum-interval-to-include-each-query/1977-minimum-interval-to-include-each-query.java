class Solution {
    public int[] minInterval(int[][] A, int[] queries) {
        int n = queries.length, m = A.length;
        // One clone of queries for sorting and ans for storing result
        int[] res = queries.clone(), ans = new int[n];
        Arrays.sort(res); // Sort queries
        int i = 0; // For iterating
         Arrays.sort(A, (a,b)->Integer.compare(a[0], b[0]));
        // Sort on basis of 1st element then if equal 2nd element

        // For Storing size and right index value
        // Treemap follows Red-Black tree and it is SORTED in Ascending
        // already(*Smallest first)
        TreeMap<Integer, Integer> mt = new TreeMap<>();
        // Map will Store size wrt queries
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int x : res) {
            while (i < m && A[i][0] <= x) {      //if queries is <= to left value then add means there
                int r = A[i][1], l = A[i++][0];  //may be chance that [] lies in range
                mt.put(r - l + 1, r);
            }
            while (!mt.isEmpty() && mt.firstEntry().getValue() < x) { //if value of query is greater
                mt.pollFirstEntry();                //means that query doesnt lies in..[] so remove
            }
            mp.put(x, (mt.isEmpty() ? -1 : mt.firstKey())); //if something available then put in map
        }
        i = 0;
        for (int xx : queries) {
            ans[i++] = mp.get(xx); //re-write with original index
        }

        return ans;
    }
}