class Solution {
    List<Integer> ls = new ArrayList<>();

    public int maxProduct(int n) {
        helper(n);
        Collections.sort(ls, Collections.reverseOrder());

        return ls.get(0) * ls.get(1);
    }

    public void helper(int n) {
        while (n > 0) {
            int x = n % 10;
            ls.add(x);
            n /= 10;
        }
    }
}