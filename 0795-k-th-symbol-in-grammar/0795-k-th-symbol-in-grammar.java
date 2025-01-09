class Solution {
    public int kthGrammar(int n, int k) {
        int mid = (int) Math.pow(2, n - 1) / 2;
        if (k == 1 && n == 1)
            return 0;
        if (mid >= k) {
            return kthGrammar(n - 1, k);
        } else {
            return 1 - kthGrammar(n - 1, k - mid);
        }
    }
}