class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder ans = new StringBuilder(s);

        while (ans.indexOf(part) != -1) {
            ans.delete(ans.indexOf(part), ans.indexOf(part)+part.length());
        }
        return ans.toString();
    }
}
/* class Solution {
    public String removeOccurrences(String s, String part) {
        String ans = s; //New string 
        while (ans.length() > 0 && ans.contains(part)) {
            ans = ans.replaceFirst(part, "");
        }
        return ans;
    }
}*/