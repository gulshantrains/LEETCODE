class Solution {
    public boolean hasSameDigits(String s) {

        int n = s.length();
        if (n == 2) {
            return s.charAt(0) == s.charAt(1);
        }
        int m = n - 2;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i <= m; i++) {
            int mod2 = lucas(m, i, 2);
            int mod5 = lucas(m, i, 5);
            int coeff = (5 * mod2 + 6 * mod5) % 10;
            int a_i = s.charAt(i) - '0';
            int a_i1 = s.charAt(i + 1) - '0';
            sum1 = (sum1 + coeff * a_i) % 10;
            sum2 = (sum2 + coeff * a_i1) % 10;
        }
        return sum1 == sum2;
    }

    private static int lucas(int n, int k, int p) {
        int res = 1;
        while (n > 0 || k > 0) {
            int ni = n % p;
            int ki = k % p;
            if (ki > ni)
                return 0;
            res = (res * comb(ni, ki, p)) % p;
            n /= p;
            k /= p;
        }
        return res;
    }

    private static int comb(int a, int b, int p) {
        if (b < 0 || b > a)
            return 0;
        if (p == 2) {
            return 1;
        } else if (p == 5) {
            switch (a) {
                case 0:
                    return 1;
                case 1:
                    return 1;
                case 2:
                    switch (b) {
                        case 0:
                            return 1;
                        case 1:
                            return 2;
                        case 2:
                            return 1;
                        default:
                            return 0;
                    }
                case 3:
                    switch (b) {
                        case 0:
                            return 1;
                        case 1:
                            return 3;
                        case 2:
                            return 3;
                        case 3:
                            return 1;
                        default:
                            return 0;
                    }
                case 4:
                    switch (b) {
                        case 0:
                            return 1;
                        case 1:
                            return 4;
                        case 2:
                            return 1;
                        case 3:
                            return 4;
                        case 4:
                            return 1;
                        default:
                            return 0;
                    }
                default:
                    return 0;
            }
        }
        return 0;
    }
}
