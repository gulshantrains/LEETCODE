class Solution {

    public String[] divideString(String s, int k, char fill) {
        List<String> ans = new ArrayList<>(); // grouped string
        
        int n = s.length();
        int curr = 0; // starting index of each group
        // split string
        while (curr < n) {
            int end = Math.min(curr + k, n);
            ans.add(s.substring(curr, end));
            curr += k;
        }
        // try to fill in the last group
        String last = ans.get(ans.size() - 1);
        if (last.length() < k) {
            last += String.valueOf(fill).repeat(k - last.length());
            ans.set(ans.size() - 1, last);
        }
        return ans.toArray(new String[0]);
    }
}