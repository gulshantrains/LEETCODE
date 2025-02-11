class Solution {
    public String removeOccurrences(String s, String part) {
        String ans = s; //New string for storing answer
        //If s conatins part then replace it with null and continue this till over
        while (ans.length() > 0 && ans.contains(part)) {
            ans = ans.replaceFirst(part, "");
        }
        return ans;
    }
}