class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] count = new int[words.length];
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String x = words[i];
            if (x.matches("^[aeiou]$") || x.matches("^[aeiou].*[aeiou]$")) {
                if (i == 0) {
                    count[i] = 1;
                    set.add(x);
                } else {
                    count[i] = count[i - 1] + 1;
                    set.add(x);
                }

            } else {
                if (i == 0) {
                    count[i] = 0;
                } else
                    count[i] = count[i - 1];
            }

        }
        for (int i = 0; i < queries.length; i++) {

            int start = queries[i][0];
            int end = queries[i][1];

            if(start==0){
                ans[i]=count[end];
            }else{
                 ans[i] = count[end]-count[start-1];
            }
           
        }
        return ans;
    }
}