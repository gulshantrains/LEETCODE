class Solution {
    public int possibleStringCount(String word) {
        Map<Character, Integer> mp = new HashMap<>();
        char[] temp = word.toCharArray();

        for (int i = 0; i < temp.length; i++) {
            if (!mp.containsKey(temp[i])) {
                mp.put(temp[i], 1);
            } else if (temp[i - 1] == temp[i]) {
                mp.merge(temp[i], 1, Integer::sum);
            }
        }
        int ans = 0;
        for (int x : mp.values()) {
            if (x > 1)
                ans += (x - 1);
        }
        return ans + 1;
    }
}