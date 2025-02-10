class Solution {
    public String clearDigits(String s) {
        String num = "0123456789";
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char x = s.charAt(i);
            
            if (!st.isEmpty() && num.contains(String.valueOf(x))) {
                st.pop();
            } else if (!num.contains(String.valueOf(x))) {
                st.push(x);
            }
        }
        StringBuilder ss = new StringBuilder("");
        while (!st.isEmpty()) {
            ss.append(st.pop());
        }
        return ss.reverse().toString();
    }
}