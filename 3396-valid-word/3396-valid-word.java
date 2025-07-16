class Solution {
    public boolean isValid(String w) {
        if (w.length() < 3) {
            return false;
        }

        int vowel = 0, cons = 0;
        for (char x : w.toCharArray()) {
            if (!Character.isLetterOrDigit(x)) {
                return false;
            }

            // Only classify letters as vowels or consonants
            if (Character.isLetter(x)) {
                if ("aeiouAEIOU".indexOf(x) != -1) {
                    vowel++;
                } else {
                    cons++;
                }
            }
        }
        return vowel >= 1 && cons >= 1;
    }
}
