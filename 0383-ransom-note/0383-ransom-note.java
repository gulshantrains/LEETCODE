class Solution {
    public boolean canConstruct(String r, String m) {
       int[] f=new  int[26];
       for(var x: m.toCharArray()) f[x-'a']++; 

       for(var x: r.toCharArray()) if(--f[x-'a']<0) return false;

       return true; 
    }
}