class Solution {
    public int canBeTypedWords(String text, String brokLet) {
        Set<Character> broke = new HashSet<>();
        for (char c : brokLet.toCharArray()) {
            broke.add(c);
        }

        int ans = 0;
        String[] res = text.split(" ");

        for (String s : res) {
            boolean flag = true;

            for (var x : s.toCharArray()) {
                if (broke.contains(x)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                ans++;
        }
        return ans;
    }
}