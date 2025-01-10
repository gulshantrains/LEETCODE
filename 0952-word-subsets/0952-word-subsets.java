class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        ArrayList<String> lst = new ArrayList<>();

        int[] target = new int[26];

        for (var x : words2) {

            int[] temp1 = new int[26];
            for (var xx : x.toCharArray()) {
                temp1[xx - 'a']++;
                target[xx - 'a'] = Math.max(target[xx - 'a'], temp1[xx - 'a']);
            }
        }

        for (var x : words1) {

            int[] temp2 = new int[26];
            for (var xx : x.toCharArray()) {
                temp2[xx - 'a']++;
            }
            if (isSubset(temp2, target)) {
                lst.add(x);
            }

        }
        return lst;
    }

    public boolean isSubset(int[] A, int[] B) {
        for (int i = 0; i < 26; i++) {
            if (A[i] < B[i])
                return false;
        }
        return true;
    }
}