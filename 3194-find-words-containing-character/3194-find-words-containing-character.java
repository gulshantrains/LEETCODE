class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
       List<Integer> ls=new ArrayList<>();
       int i=0;

       for(var w: words){
        for(var z: w.toCharArray()){
            if(z==x){
                ls.add(i);
                break;
            }
        }
        i++;
       } 
       return ls;
    }
}