class Solution {
    public int compareVersion(String ver1, String ver2) {
        String[] v1 = ver1.split("\\.");
        String[] v2 = ver2.split("\\.");

        int i = 0, j = 0;

        while (i < v1.length || j < v2.length) {
            // if i or j is out of bounds, treat as 0 (Given in Qns otherwise we may get AOI)
            int t1 = (i < v1.length) ? Integer.parseInt(v1[i]) : 0;
            int t2 = (j < v2.length) ? Integer.parseInt(v2[j]) : 0;

            if (t1 > t2) return 1;
            if (t1 < t2) return -1;

            i++;
            j++;
        }
        return 0;
    }
}
