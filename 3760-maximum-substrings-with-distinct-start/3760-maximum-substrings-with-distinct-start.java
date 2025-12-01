class Solution {
    public int maxDistinct(String s) {
      Set<Character> ch=new HashSet<>();
      for(char x: s.toCharArray()) ch.add(x);

      return ch.size();  
    }
}