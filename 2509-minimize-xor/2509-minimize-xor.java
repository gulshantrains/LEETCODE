class Solution {
    public boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    public int Set(int x, int bit) {
        return x | (1 << bit);
    }

    public int unSet(int x, int bit) {
        return x & ~(1 << bit);
    }

    public int minimizeXor(int num1, int num2) {
        int x = num1;
        int reqdbitCount = Integer.bitCount(num2);
        int orgbitCount = Integer.bitCount(x);

        int bit = 0;

        if (reqdbitCount > orgbitCount) {
            while (reqdbitCount > orgbitCount) {
                if (!isSet(x, bit)) {
                    x = Set(x, bit);
                    orgbitCount++;
                }
                bit++;
            }
        } else if (reqdbitCount < orgbitCount) {
            while (reqdbitCount < orgbitCount) {
                if (isSet(x, bit)) {
                    x = unSet(x, bit);
                    orgbitCount--;
                }
                bit++;
            }
        }
        return x;
    }
}