class Solution {
    public String reverseVowels(String s) {
        StringBuilder vow = new StringBuilder("");
        StringBuilder ans = new StringBuilder("");

        String che = "AEIOUaeiou";

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);

            if (che.indexOf(temp) != -1)
                vow.append(temp);
        }
        int sz = vow.length();
        int l = sz - 1;

        for (int i = 0; i < s.length(); i++) {
            char temp2 = s.charAt(i);

            if (che.indexOf(temp2) == -1) {
                ans.append(temp2);
            } else {
                if (l >= 0) {
                    ans.append(vow.charAt(l));
                    l--;
                }

            }
        }
        return ans.toString();

    }
}