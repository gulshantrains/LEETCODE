class Solution {
    public boolean canConstruct(String s, int k) {
        if (k > s.length())
            return false;

        int[] chridx = new int[26];
        int odd = 0;

        for (var x : s.toCharArray()) {
            chridx[x - 'a']++;
        }
        for (int x : chridx) {
            if (x != 0 && x % 2 != 0)
                odd++;
        }
        System.out.println(odd);
        if (odd > k)
            return false;
        return true;
    }
}