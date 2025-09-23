class Solution {
    public int compareVersion(String ver1, String ver2) {
        String[] v1 = ver1.split("\\.");
        String[] v2 = ver2.split("\\.");

        int i = 0, j = 0;

        while (i < v1.length || j < v2.length) {
            // handle missing parts as 0
            String s1 = (i < v1.length) ? v1[i] : "0";
            String s2 = (j < v2.length) ? v2[j] : "0";

            int t1 = Integer.parseInt(removez(s1));
            int t2 = Integer.parseInt(removez(s2));

            if (t1 > t2) return 1;
            if (t1 < t2) return -1;

            i++;
            j++;
        }
        return 0;
    }

    public String removez(String x) {
        int i = 0;
        // skip leading zeros but stop at last character
        while (i < x.length() - 1 && x.charAt(i) == '0') {
            i++;
        }
        return x.substring(i);
    }
}
