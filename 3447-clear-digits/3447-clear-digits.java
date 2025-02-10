class Solution {
    public String clearDigits(String s) {
        int n = s.length(), k = -1;
        StringBuilder ss = new StringBuilder("");

        for (int i = 0; i < n; i++) {
            char x = s.charAt(i);
//x is a character between a...z so append it and increase counter value
            if (x >= 'a' && x <= 'z') {
                ss.append(x);
                k++;
            } else {
                //X is not a character 
                //and counter value is >=0 means atleast one character exist
                if (k >= 0) { 
                    ss.deleteCharAt(k);
                    k--;
                } else {
                    ss.append(x);//if not character is before then append number
                }
            }
        }
        return ss.toString();

    }
}