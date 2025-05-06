class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ls = new ArrayList<>();
        int[] cnt = new int[26];
        int n = p.length(), m = s.length();

        //We put count in frequency Array
        for (int i = 0; i < n; i++) {
            cnt[p.charAt(i) - 'a']++;
        }

        int i = 0, j = 0;

        while (j < m) {
            cnt[s.charAt(j) - 'a']--;

            if (j - i + 1 == n) {
                if (is(cnt))
                    ls.add(i);

                cnt[s.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }
        return ls;

    }

    public boolean is(int[] a) {
        for (var x : a) {
            if (x != 0)
                return false;
        }
        return true;
    }
}