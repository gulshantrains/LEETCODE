class Solution {
    public List<String> removeSubfolders(String[] A) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(A);
        // for (String x : A)
        //     System.out.println(x);

        for (String x : A) {
            if (ans.isEmpty() || !x.startsWith(ans.get(ans.size() - 1) + "/"))
                ans.add(x);
        }
        return ans;
    }
}