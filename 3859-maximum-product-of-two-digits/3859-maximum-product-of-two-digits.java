class Solution {
    List<Integer> ls = new ArrayList<>();

    public int maxProduct(int n) {
        helper(n);
        Collections.sort(ls);
        int s = ls.size();

        int ans = ls.get(s - 1) * ls.get(s - 2);
        return ans;
    }

    public void helper(int n) {
        while (n > 0) {
            int x = n % 10;
            ls.add(x);
            n /= 10;
        }
    }
}