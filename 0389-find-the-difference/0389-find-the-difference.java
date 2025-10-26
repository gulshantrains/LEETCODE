class Solution {
    public char findTheDifference(String s, String t) {
        int ans=0;

        for(var x: t.toCharArray()) ans ^=x;
        for(var x: s.toCharArray()) ans ^=x;

        return (char)ans;
        
    }
}