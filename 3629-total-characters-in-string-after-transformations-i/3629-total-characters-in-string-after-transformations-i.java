class Solution {
    public static int mod = 1000000007;

    public int lengthAfterTransformations(String s, int t) {
        int[] map = new int[26];

        for (var x : s.toCharArray())
            map[x - 'a']++;

        while (t-- > 0) {
            int[] temp = new int[26];

            temp[0] = map[25];
            temp[1] = map[25];

            for (int i = 0; i < 25; i++) {
                temp[i + 1] = (map[i] + temp[i + 1]) % mod;
            }
            map = temp;
        }
        int ans = 0;
        for (var xx : map)
            ans = (ans + xx) % mod;

        return ans % mod;
    }
}