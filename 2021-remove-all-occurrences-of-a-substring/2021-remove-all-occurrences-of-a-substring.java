class Solution {
    public String removeOccurrences(String s, String part) {
        String ans = s; //New string 
        while (ans.length() > 0 && ans.contains(part)) {
            ans = ans.replaceFirst(part, "");
        }
        return ans;
    }
}