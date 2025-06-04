class Solution {
    public String answerString(String word, int nF) {
        int n = word.length();
        String ans = "";

        if (nF == 1)
            return word;

        int maxL = (n - (nF - 1)); //Give Favour to one friend and allot him biggest with Largest character

        for (int i = 0; i < n; i++) {
            int act = Math.min(maxL, n - i);

            String temp = word.substring(i, i + act);
           // System.out.println(temp);

            if (ans.compareTo(temp) <= 0) {
                ans = temp;
            }
        }
        return ans;
    }
}