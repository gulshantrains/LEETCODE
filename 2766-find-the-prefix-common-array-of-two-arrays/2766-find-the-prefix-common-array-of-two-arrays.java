class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] freq = new int[50];
        int[] ans = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            int f1 = A[i], f2 = B[i];
            freq[f1-1]++;
            freq[f2-1]++;

            int cnt = 0;
            for (int x : freq) {
                if (x == 0)
                    continue;
                if (x == 2)
                    cnt++;
            }
            ans[i]=cnt;
        }
        return ans;
    }
}