class Solution {

    public int maxDiff(int num) {
        String numStr = String.valueOf(num);

        // Step 1: Create the maximum number by replacing the first non-'9' digit with '9'
        String maxStr = numStr;
        for (char c : numStr.toCharArray()) {
            if (c != '9') {
                maxStr = numStr.replace(c, '9');
                break;
            }
        }
        int maxNum = Integer.parseInt(maxStr);

        // Step 2: Create the minimum number by replacing
        // - the first digit (if not '1') with '1', or
        // - the first non-'0'/'1' digit (after first) with '0'
        String minStr = numStr;
        char firstChar = numStr.charAt(0);

        if (firstChar != '1') {
            minStr = numStr.replace(firstChar, '1');
        } else {
            for (int i = 1; i < numStr.length(); i++) {
                char c = numStr.charAt(i);
                if (c != '0' && c != '1') {
                    minStr = numStr.replace(c, '0');
                    break;
                }
            }
        }
        int minNum = Integer.parseInt(minStr);

        // Return the difference between maximum and minimum numbers
        return maxNum - minNum;
    }
}
