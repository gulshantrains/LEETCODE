class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (n == k || k > n)
            return "0";

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            int val = num.charAt(i) - '0';

            //We want Smallest digit on Least Significiant Place so removr if we have seen smaller number and also k>0
            while (!st.isEmpty() && k > 0 && st.peek() > val) {
                st.pop();
                k--;
            }
            st.push(val);
        }
    //When Number is Increasing 1,2,3,4,5,6,7 then we have to remove from top
        while (k > 0) {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (int x : st) //Enhanced loop to track bottom to top
            sb.append(x);

        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.length() == 0 ? "0" : sb.toString();

    }
}