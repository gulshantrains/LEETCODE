class Solution {
    public String smallestNumber(String pat) {
        int n = pat.length(), num = 1;
        Stack<Integer> st = new Stack<>();
        StringBuilder ans = new StringBuilder(""); // Size=1,2....n+1

        for (int i = 0; i <= n; i++) { // Loop goes up to n to process the last number
            st.push(num++);

            if (i == n || pat.charAt(i) == 'I') { // When we see 'I' or at the end, resolve stack
                while (!st.isEmpty()) {
                    ans.append(st.pop());
                }
            }
        }

        return ans.toString();
    }
}