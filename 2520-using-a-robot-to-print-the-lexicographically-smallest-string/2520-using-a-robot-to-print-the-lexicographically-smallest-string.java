class Solution {
    public String robotWithString(String s) {
        int n = s.length();

        char[] mcr = new char[n + 1];
        mcr[n] = '{'; 
        
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                mcr[i] = s.charAt(i);
            } else {
                mcr[i] = (char) Math.min(s.charAt(i), mcr[i + 1]);
            }
        }

        // Use a StringBuilder for the robot's temporary string, t.
        StringBuilder t = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        // Iterate through the input string s.
        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            
            t.append(currentChar);

            while (t.length() > 0 && t.charAt(t.length() - 1) <= mcr[i + 1]) {
                ans.append(t.charAt(t.length() - 1));
                
                t.deleteCharAt(t.length() - 1);
            }
        }


        ans.append(t.reverse());
        
        return ans.toString();
    }
}