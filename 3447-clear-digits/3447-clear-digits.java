class Solution {
    public String clearDigits(String s) {
        String num = "0123456789"; // To check if x is number or not
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char x = s.charAt(i);

            // If stack top element is character and current char is NUMBER then pop top
            // element
            if (!st.isEmpty() && num.contains(String.valueOf(x)))
                st.pop();
            else if (!num.contains(String.valueOf(x)))
                st.push(x);// Push char is it is not a NUMBER

        }
        StringBuilder ss = new StringBuilder("");
        while (!st.isEmpty()) {
            ss.append(st.pop());
        }
        return ss.reverse().toString();
    }
}