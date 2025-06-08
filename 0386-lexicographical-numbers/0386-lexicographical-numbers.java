class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= 9; i++) { //Start from 1 and then its all children then move to 2
            dfs(i, n, ans);
        }
        return ans;
    }

    private void dfs(int num, int limit, List<Integer> ls) {
        if (num > limit)
            return;

        ls.add(num);

        for (int i = 0; i <= 9; i++) {
            int nextnum = 10 * num + i;

            if (nextnum <= limit)
                dfs(nextnum, limit, ls);
            else
                break;
        }
    }
}