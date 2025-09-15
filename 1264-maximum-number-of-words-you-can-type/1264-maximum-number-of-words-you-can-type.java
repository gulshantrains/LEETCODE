class Solution {
    public int canBeTypedWords(String text, String brokeL) {
        boolean[] c = new boolean[26];
        for (int i = 0; i < brokeL.length(); i++)
            c[brokeL.charAt(i) - 97] = true;

        int count = 1;
        boolean flag = true;

        for (char x : text.toCharArray()) {
            if (x == ' ') {
                count++;
                flag = true;
            } else if (c[x - 97] && flag) {
                count--;
                flag = false; //It will prevent to count twice is two words are broke
            }
        }
        return count < 0 ? 0 : count;
    }
}
/*
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
*/