class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> st = new Stack<>();
        Stack<Character> rev = new Stack<>();
        int ans = 0;

        if (y > x) {
            // Prioritize removing "ba"
            for (char ch : s.toCharArray()) {
                if (!st.isEmpty() && st.peek() == 'b' && ch == 'a') {
                    st.pop();
                    ans += y;
                } else {
                    st.push(ch);
                }
            }

            // Process remaining for "ab"
            while (!st.isEmpty()) {
                char ch = st.pop();
                if (!rev.isEmpty() && rev.peek() == 'b' && ch == 'a') {
                    rev.pop();
                    ans += x;
                } else {
                    rev.push(ch);
                }
            }

        } else {
            // Prioritize removing "ab"
            for (char ch : s.toCharArray()) {
                if (!st.isEmpty() && st.peek() == 'a' && ch == 'b') {
                    st.pop();
                    ans += x;
                } else {
                    st.push(ch);
                }
            }

            // Process remaining for "ba"
            while (!st.isEmpty()) {
                char ch = st.pop();
                if (!rev.isEmpty() && rev.peek() == 'a' && ch == 'b') {
                    rev.pop();
                    ans += y;
                } else {
                    rev.push(ch);
                }
            }
        }

        return ans;
    }
}
