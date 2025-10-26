class Solution {
    public int firstUniqChar(String s) {
       int[] f=new int[26];
       for(char x: s.toCharArray()) f[x-'a']++;

       for(int i=0; i<s.length(); i++){
        if(f[s.charAt(i)-'a']==1) return i;
       } 

       return -1;
    }
}