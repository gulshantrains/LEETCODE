class Solution {
    public int finalValueAfterOperations(String[] o) {
        int ans = 0;

        for (var x : o) {
            if (x.equals("--X") || x.equals("X--"))
                ans--;
            else
                ans++;
        }
        return ans;

    }
}