class Solution {
    public int minimumRecolors(String blok, int k) {
        int count = 0;
        int ans = 100000;

        for (int i = 0; i < blok.length(); i++) {
            if (blok.charAt(i) == 'B')
                count++;
            else
                count = 0;
        }
        if (count >= k)
            return 0;
        else {
            for (int i = 0; i < blok.length(); i++) {
                int temp = 0; // operation count
                int b = 0; // count B
                for (int j = i; i + k <= blok.length() && j < i + k; j++) {
                    if (blok.charAt(j) == 'B') {
                        b++;
                    } else {
                        temp++;
                        b++;
                    }
                    if (b == k)
                        ans = Math.min(ans, temp);
                }
            }
            return ans;
        }
    }
}