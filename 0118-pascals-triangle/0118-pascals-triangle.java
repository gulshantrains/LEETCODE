class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();

            if (i == 0) {
                temp.add(1);
            } else {
                curr = ans.get(i - 1);
                temp.add(1);
                for (int j = 1; j < i; j++) {
                    temp.add(curr.get(j - 1) + curr.get(j));
                }
                temp.add(1);
            }
            ans.add(temp);
        }
        return ans;
    }
}